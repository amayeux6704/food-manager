/**
 *
 * @author Alexander
 */
public class ReceiptGenerator {
    
    public void showReceipt(Order order){
        String str;
        
        Customer customer = order.getCustomer();
        
        str = "Order for: " + customer.getName() +"\n"+
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
        
        System.out.println(str);
        order.displayTaxRate();
        order.displayTaxCost();
        order.displayTotalCost();
    }
}
