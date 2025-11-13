
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Alexander
 */
public class OrderManager {
    
    private Map<Integer, Order> orders;
    private Person person;
    
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
        if(orders.isEmpty()){System.out.println("There are no orders here yet!\n");}
        else
        {
            for(int id: orders.keySet()){
                Order order = searchOrder(id);
                System.out.println(order);
                System.out.println("______________________________________________\n");
            }
        }
    }
    
    public void showUnfulfilledOrders(){
        boolean allFulfilled = true;
        
        if(orders.isEmpty()){System.out.println("There are no orders here yet!\n");}
        else
        {
            for(int id: orders.keySet()){
                Order order = searchOrder(id);
                    if(!order.isFulfilled()){
                        allFulfilled = false;
                        System.out.println(order);
                        System.out.println("______________________________________________\n");
                }
            }
            if(allFulfilled){System.out.println("All orders have been fulfilled!\n");}
        }
    }
}
