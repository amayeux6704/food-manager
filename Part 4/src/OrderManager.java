
import java.util.Map;
import java.util.HashMap;

/**
 * This class stores and manages multiple orders within the system.
 * @author Alexander
 */
public class OrderManager {
    
    /**
     * A Map that stores all of the order objects. The map uses the order IDs as
     * the keys, and the Order objects as the values.
     */
    private Map<Integer, Order> orders;
    
    /**
     * Class constructor that initializes the orders Map as a new HashMap.
     */
    public OrderManager(){
        orders = new HashMap<>();
    }
    
    /**
     * This method adds a new order to the orders map based on the input order
     * object parameter. It retrieves the order's ID number to use as the key
     * to be associated with the stored Order object.
     * 
     * @param order The order to be added to the system.
     */
    public void addOrder(Order order){
        int id = order.getOrderId();
        orders.put(id, order);
    }
    
    /**
     * This method searches for the order associated with the input ID 
     * parameter. The order associated with that ID number in the orders Map is 
     * returned.
     * 
     * @param id The ID number associated with the order to be searched.
     * @return The order associated with the input ID.
     */
    public Order searchOrder(int id){
        return orders.get(id);
    }
    
    /**
     * This method removes an order from the orders Map based on the input
     * order ID number. If the searchOrder() method returns an order
     * object associated with that ID, the order is removed from the
     * orders Map, and a message is displayed informing the user that the
     * order's information has been deleted successfully. Otherwise, a 
     * message is displayed informing the user that no order with the
     * provided ID exists.
     * 
     * @param id The ID number associated with the order to be removed.
     */
    public void removeOrder(int id){
        
        if(searchOrder(id) != null){
            orders.remove(id);
            System.out.println("This order has been removed successfully.");
        }
        else
            System.out.println("No order with this ID exists");
    }
    
    /**
     * This method shows all of the orders stored in this OrderManager object.
     * If the orders Map is empty, the noOrdersHerePrompt() method is called 
     * to inform the user that there is no order history. Otherwise, for each
     * order in the orders Map, the displayOrder() method is called to display
     * the information about each order to the user.
     */
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
    
    /**
     * This method returns the orders map containing all of the orders within
     * this OrderManager object.
     * 
     * @return The orders Map instance variable.
     */
    public Map<Integer, Order> getAllOrders(){
        return orders;
    }
    
    /**
     * This method displays all of the orders that are available for a delivery
     * person to take on as a job. A Boolean value to be used to determine if 
     * no orders are available is initialized to true. If there are no orders in 
     * the orders Map, the noOrdersHerePrompt() method is called. Otherwise, 
     * each order is evaluated to determine whether they have a delivery driver 
     * associated with them. If the current order does not have a delivery
     * driver, the noneAvailable variable is set to false and the information
     * about the order is displayed to the user. Once all of the orders are
     * evaluated, if no orders are available, the noOrdersPrompt() method is
     * called. Finally, the opposite value of the noneAvailable variable is 
     * returned.
     * 
     * @return The opposite value of the noneAvailable Boolean variable.
     */
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
    
    /**
     * This method returns a Map containing all of the orders that are available
     * for a delivery person to take on as a job. If the orders Map is not empty,
     * each order is evaluated to determine if they have a delivery person
     * assigned to them. If the order does not have a delivery driver, it is
     * added to the availableOrders Map. Once all of the orders have been
     * evaluated, the availableOrders Map containing all of the available orders
     * is returned.
     * 
     * @return The availableOrders Map containing all of the available orders.
     */
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
    
    /**
     * This method displays all of the orders that a delivery person has not
     * yet fulfilled. A Boolean value to be used to determine if all orders have
     * been fulfilled is initialized to true. If there are no orders in 
     * the orders Map, the noOrdersHerePrompt() method is called. Otherwise, 
     * each order is evaluated to determine whether they have been fulfilled. If
     * the current order has not been fulfilled, the allFulfilled variable is 
     * set to false and the information about the order is displayed to the 
     * user. Once all of the orders are evaluated, if no orders have been left
     * unfulfilled, the noOrdersPrompt() method is called. Finally, the opposite 
     * value of the allFulfilled variable is returned.
     * 
     * @return The opposite value of the allFulfilled Boolean variable.
     */
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
    
    /**
     * This method returns a Map containing all of the orders that a delivery
     * person has not yet fulfilled. If the orders Map is not empty, each order 
     * is evaluated to determine if they have been fulfilled. If the order has 
     * not been fulfilled, it is added to the unfulfilledOrders Map. Once all of
     * the orders have been evaluated, the unfulfilledOrders Map containing all 
     * of the unfulfilled orders is returned.
     * 
     * @return The unfulfilledOrders Map containing all of the unfulfilled '
     *         orders.
     */
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
    
    /**
     * This method displays a message to the user informing them that there are
     * no orders stored in this OrderManager object yet.
     */
    public void noOrdersHerePrompt(){System.out.println("There are no orders here yet!\n");}
    
    /**
     * This method displays the information about the input order object
     * parameter.
     * 
     * @param order The order object to be displayed.
     */
    public void displayOrder(Order order){
        System.out.println(order);
        System.out.println("______________________________________________\n");
    }
}
