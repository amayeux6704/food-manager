
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Alexander
 */
public class OrderManager {
    
    private Map<Integer, Order> orders;
    private Person person;
    
    public OrderManager(){
        orders = new HashMap<>();
    }
    
    public OrderManager(Person person){
        orders = new HashMap<>();
        this.person = person;
    }
    
    public void addOrder(Order order){
        int id = order.getOrderId();
        orders.put(id, order);
    }
    
    public Order searchOrder(int id){
        return orders.get(id);
    }
    
    public void removeOrder(int id){
        
        if(searchOrder(id) != null){
            orders.remove(id);
            System.out.println("This order has been removed successfully.");
        }
        else
            System.out.println("No order with this ID exists");
    }
    
    public void showOrderHistory(){
        if(orders.isEmpty()){noOrdersHerePrompt();}
        else
        {
            for(int id: orders.keySet()){
                Order order = searchOrder(id);
                displayOrder(order);
            }
        }
    }
    
    public Map<Integer, Order> getAllOrders(){
        return orders;
    }
    
    public boolean showAvaliableOrders(){
        boolean noneAvailable = true;
        
        if(orders.isEmpty()){noOrdersHerePrompt();}
        else
        {
            for(int id: orders.keySet()){
                Order order = searchOrder(id);
                    if(order.getDeliveryPerson() == null){
                        noneAvailable = false;
                        displayOrder(order);
                }
            }
        }
        if(noneAvailable){noOrdersHerePrompt();}
        
        return !noneAvailable;
    }
    
    public Map<Integer, Order> getAvailableOrders(){
        Map<Integer, Order> availableOrders = new HashMap<>();
        
        if(!orders.isEmpty()){
            for(int id: orders.keySet()){
                Order order = searchOrder(id);
                    if(order.getDeliveryPerson() == null){
                        availableOrders.put(id, order);
                }
            }
        }
        
        return availableOrders;
    }
    
    public boolean showUnfulfilledOrders(){
        boolean allFulfilled = true;
        
        if(orders.isEmpty()){noOrdersHerePrompt();}
        else
        {
            for(int id: orders.keySet()){
                Order order = searchOrder(id);
                    if(!order.isFulfilled()){
                        allFulfilled = false;
                        displayOrder(order);
                }
            }
            if(allFulfilled){System.out.println("All orders have been fulfilled!\n");}
        }
        
        return !allFulfilled;
    }
    
    public Map<Integer, Order> getUnfulfilledOrders(){
        Map<Integer, Order> unfulfilledOrders = new HashMap<>();
        
        if(!orders.isEmpty()){
            for(int id: orders.keySet()){
                Order order = searchOrder(id);
                    if(!order.isFulfilled()){
                        unfulfilledOrders.put(id, order);
                }
            }
        }
        
        return unfulfilledOrders;
    } 
    
    public void noOrdersHerePrompt(){System.out.println("There are no orders here yet!\n");}
    
    public void displayOrder(Order order){
        System.out.println(order);
        System.out.println("______________________________________________\n");
    }
}
