/**
 *
 * @author Alexander
 */
public class ReceiptGenerator {
    
    public void showReceipt(Order order){
        String str;
        
        Customer customer = order.getCustomer();
        
        str = "Order for: " + customer.getName() +"\n"+
              "______________________________________________\n";
        
        for(Dish dish: order.getContents()){
            str += dish.getName() + ": " + dish.getPrice()+ "\n";
        }
        
        System.out.println(str);
    }
}
