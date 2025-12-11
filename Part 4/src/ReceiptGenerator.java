/**
 * This class generates order receipts for orders.
 * @author Alexander
 */
public class ReceiptGenerator {
    
    /**
     * This method generates an order receipt and displays it to the command
     * line.
     * 
     * @param order The order whose receipt is being generated.
     */
    public void showReceipt(Order order){
        
        System.out.println(createReceipt(order));
    }
    
    /**
     * This method generates an order receipt as a string to be displayed
     * after an order has been placed. It shows the name of  the customer who 
     * placed the order, their ID, the order ID, the list of  dishes, the list 
     * of sides, and all of the price information. 
     * 
     * @param order The order whose receipt is being generated.
     * @return The generated receipt string (str).
     */
    public String createReceipt(Order order){
        String str;
        
        Customer customer = order.getCustomer();
        
        str = "<Order for: " + customer.getName() +"\n"+
              "Customer #" + customer.getID() + "\n" +
              "______________________________________________\n"+
              "Order #" + order.getOrderId() + "\n" +
              "______________________________________________\n"+
              "Dishes:\n"+
              "----------------------------------------------\n";
        
        for(Dish dish: order.getDishes()){
            str += dish.toString() + "\n";
        }
        str += "Sides:\n"+
              "----------------------------------------------\n";
        for(Side side: order.getSides()){
            str += side.getName() + "\n";
        }
        str +=  order.getTaxRate() + "\n" +
                order.getTaxCost() + "\n" +
                order.getTotalCost() +"\n";
        
        return str;
    }
}
