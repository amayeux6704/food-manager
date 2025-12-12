
import java.io.*;

/**
 *
 * @author Alexander
 */
public class LoadSaveOrder {
    
    public Order loadOrder(int id, Menu menu, CostCalculation cc, 
            CustomerManager cm, DeliveryPersonManager dpm){
        
        
        String fileName = "txtDataFiles/orderFiles/o" + id + ".txt";
        System.out.println(fileName);
        try{
            Order order;
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            String[] tempArr;
            
            line = br.readLine();
            
            tempArr = line.split(",");

            int orderId = Integer.parseInt(tempArr[0]);
            boolean fulfilled = Boolean.parseBoolean(tempArr[1]);
            order = new Order(orderId, menu, cc);
            order.setFulfillment(fulfilled);
            
            while((line = br.readLine()) != null){
                
                tempArr = line.split(",");
                
                String type = tempArr[0];
                
                switch(type){
                    case "~c":
                        setCustomer(order, cm, tempArr);
                        break;
                    case "~d":
                        setDish(order, tempArr);
                        break;
                    case "~s":
                        setSide(order, menu, tempArr);
                        break;
                    case "~a":
                        setAddress(order,tempArr);
                        break;
                    case "~p":
                        setPayMethod(order, tempArr);
                        break;
                    case "~dp":
                        setDeliveryPerson(order, dpm, tempArr);
                        break;
                    
                }
            }
            br.close();
            order.calculateTotalCost();
            System.out.println(order);
            
            return order;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
    }
    
    private void setCustomer(Order order, CustomerManager cm, String[] tempArr){
        
        
        int custId = Integer.parseInt(tempArr[1]);
        
        Customer customer = cm.searchCustomer(custId);
        
        order.setCustomer(customer);
        
        customer.getOrderHistory().addOrder(order);
    }
    
    private void setDish(Order order, String[] tempArr){
        if(tempArr.length > 1){
            int dishId = Integer.parseInt(tempArr[1]);

            order.addDish(dishId);
        }
    }
    
    private void setSide(Order order, Menu menu, String[] tempArr){
        if(tempArr.length > 1){
            String sideName = tempArr[1];
        
            for(Side side: menu.getSides()){
                if(side.getName().equals(sideName)){
                    
                    order.addSide(side);
                }
            }
        }
    }
    
    private void setAddress(Order order, String[] tempArr){
        int addrId = Integer.parseInt(tempArr[1]);
        
        Address address = order.getCustomer().getAddressManager().searchAddress(addrId);
        
        order.setAddress(address);
    }
    
    private void setPayMethod(Order order, String[] tempArr){
        
        String payMethod = tempArr[1];
        
        order.setPayMethod(payMethod);
    }
    
    private void setDeliveryPerson(Order order, DeliveryPersonManager dpm, String[] tempArr){
        if(tempArr.length > 1){
        
            int empId = Integer.parseInt(tempArr[1]);

            DeliveryPerson deliveryPerson = dpm.searchDeliveryPerson(empId);
        
            order.setDeliveryPerson(deliveryPerson);
            
            deliveryPerson.getOrderHistory().addOrder(order);
            
        }
    }
    
    public void saveOrder(Order order){
        int id = order.getOrderId();
        String fileName = "txtDataFiles/orderFiles/o" + id + ".txt";
        
        try{
            File file = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            
            bw.write(id + "," + order.isFulfilled() + ",\n");
            bw.write("~c," + order.getCustomer().getID() + "\n");
            
            if(order.getDishes().isEmpty())
                bw.write("~d,,\n");
            else{
                for(Dish dish: order.getDishes()){
                    int currId = dish.getDishID();
                    bw.write("~d," + currId + ",\n");
                }
            }
            
            if(order.getSides().isEmpty())
                bw.write("~s,,\n");
            else{
                for(Side side: order.getSides()){
                    String sideName = side.getName();
                    bw.write("~s," + sideName + ",\n");
                }
            }
            
            bw.write("~a," + order.getAddress().getAddressID()+ ",\n");
            bw.write("~p," + order.getPayMethod()+ ",\n");
            if(order.getDeliveryPerson() == null)
                bw.write("~dp,,\n");
            else{
                bw.write("~dp," + order.getDeliveryPerson().getID() + ",\n");
                
            }
            
            bw.close();
        }
        catch(IOException e){
            System.out.println(e);    
        }    
    }
    
    public OrderManager loadOrderManager(Menu menu, CostCalculation cc,
            CustomerManager cm, DeliveryPersonManager dpm){
        
        String fileName = "txtDataFiles/orderFiles/oIDList.txt";
        try{
            OrderManager om = new OrderManager();
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";

            while((line = br.readLine()) != null){
                Order order = loadOrder(Integer.parseInt(line), menu, cc, cm, dpm);
                om.addOrder(order);
                
            }
            br.close();
            
            return om;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
    }
    
    public void saveOrderManager(OrderManager gom){
        String fileName = "txtDataFiles/orderFiles/oIDList.txt";
        
        try{
            File file = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            for(int id: gom.getAllOrders().keySet()){
                bw.write(id + "\n");
            }
            bw.close();
        }
        catch(IOException e){
            System.out.println(e);    
        }
    }
}
