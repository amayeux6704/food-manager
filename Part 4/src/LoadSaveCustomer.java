
import java.io.*;

/**
 *
 * @author Alexander
 */
public class LoadSaveCustomer {
    
    public Customer loadCustomer(int id){
        
        String fileName = "txtDataFiles/customerFiles/c" + id + ".txt";
        try{
            Customer customer;
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            String[] tempArr;
            
            line = br.readLine();
            
            tempArr = line.split(",");
            
            String name = tempArr[0];
            int custId = Integer.parseInt(tempArr[1]);
            boolean isGuest = Boolean.parseBoolean(tempArr[2]);
            customer = new Customer(name, custId, isGuest);
            customer.setEmail(tempArr[3]);
            customer.setPassword(tempArr[4]);
            
            while((line = br.readLine()) != null){
                
                tempArr = line.split(",");
                
                String type = tempArr[0];
                
                switch(type){
                    case "~p":
                        setPayMethod(customer, tempArr);
                        break;
                    case "~a":
                        setAddress(customer, tempArr);
                        break;
                    case "~ph":
                        setPhone(customer, tempArr);
                        break;
                    
                }
            }
            br.close();
            
            return customer;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
    }
    
    private void setPayMethod(Customer customer, String[] tempArr){
        if(tempArr.length > 1){
            customer.getPayment().addPayMethod(tempArr[1]);
        }
        if(tempArr.length > 2){
            customer.getPayment().addPayMethod(tempArr[1]);
            if(tempArr[2].equals("curr")){
                customer.getPayment().setCurrentPayMethod(tempArr[1]);
            }
        }
            
    }
    
    private void setAddress(Customer customer, String[] tempArr){
        if(tempArr.length > 1){
            int addrId = Integer.parseInt(tempArr[1]);
            Address address = new Address(customer, addrId);
            address.setLine1(tempArr[2]);
            address.setLine2(tempArr[3]);
            address.setCity(tempArr[4]);
            address.setState(tempArr[5]);
            address.setZipCode(tempArr[6]);
            customer.getAddressManager().addAddress(address);
            if(Boolean.parseBoolean(tempArr[7]))
                customer.getAddressManager().setPrimaryAddress(addrId);
        }
    }
    private void setPhone(Customer customer, String[] tempArr){
        if(tempArr.length > 1)
            customer.getPNM().addPhoneNumber(tempArr[1]);
    }
    
    public void saveCustomer(Customer customer){
        int id = customer.getID();
        String fileName = "txtDataFiles/customerFiles/c" + id + ".txt";
        
        try{
            File file = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            
            bw.write(writeCustomer(customer));
            
            if(customer.getPayment().getPayMethods().isEmpty())
                bw.write("~p,,,\n");
            else{
                for(String payment: customer.getPayment().getPayMethods()){
                    if(customer.getPayment().getCurrentPayMethod().equals(payment))
                        bw.write("~p," + payment + ",curr,\n");
                    else{
                        bw.write("~p," + payment + ",,\n");
                    }
                }
            }
            
            if(customer.getAddressManager().getNumAddresses() == 0)
                bw.write("~a,,,,,,,,\n");
            else{
                for(int i = 1; i <= customer.getAddressManager().getNumAddresses(); i++){
                    Address addr = customer.getAddressManager().searchAddress(i);
                
                    bw.write(writeAddress(addr));
                }
            }
            
            if(customer.getPNM().getPhoneNumbers().isEmpty())
                bw.write("~ph,,\n");
            else{
                for(String phone: customer.getPNM().getPhoneNumbers()){
                    bw.write("~ph," + phone + ",\n");
                }
            }
            
            bw.close();
        }
        catch(IOException e){
            System.out.println(e);    
        }    
    }
    
    private String writeCustomer(Customer customer){
        return customer.getName() + "," + customer.getID() + "," + 
                customer.isGuest() + "," + customer.getEmail() + "," +
                customer.getPassword() + ",\n";
    }
    
    private String writeAddress(Address address){
        return "~a," + address.getAddressID() + "," + address.getLine1() + 
                "," + address.getLine2() + "," + address.getCity()+ "," + 
                address.getState()+ "," + address.getZipCode() + "," +
                address.isPrimary() + ",\n";
    }
    
    public CustomerManager loadCustomerManager(){
        String fileName = "txtDataFiles/customerFiles/cIDList.txt";
        try{
            CustomerManager cm = new CustomerManager();
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            
            while((line = br.readLine()) != null){
                Customer customer = loadCustomer(Integer.parseInt(line));
                cm.addCustomer(customer);
                
            }
            br.close();
            
            return cm;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
    }
    
    public void saveCustomerManager(CustomerManager cm){
        String fileName = "txtDataFiles/customerFiles/cIDList.txt";
        try{
            File file = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            for(int id: cm.getCustomers().keySet()){
                bw.write(id + "\n");
            }
            
            bw.close();
            
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
