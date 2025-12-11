
import java.io.*;

/**
 *
 * @author Alexander
 */
public class LoadSaveCustomer {
    
    public Customer LoadCustomer(int id){
        
        String fileName = "txtDataFiles/customerFiles/c" + id + ".txt";
        System.out.println(fileName);
        try{
            Customer customer;
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            String[] tempArr;
            
            //Load Customer name, id, email, guest status, and password,
            
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
            System.out.println(customer);
            
            return customer;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
    }
    
    private void setPayMethod(Customer customer, String[] tempArr){
        customer.getPayment().addPayMethod(tempArr[1]);
    }
    
    private void setAddress(Customer customer, String[] tempArr){
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
    private void setPhone(Customer customer, String[] tempArr){
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
                bw.write("~p,,\n");
            else{
                for(String payment: customer.getPayment().getPayMethods()){
                    bw.write("~p," + payment + ",\n");
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
}
