
import java.util.Scanner;


/**
 *
 * @author Alexander
 */
class EmployeeSubmenuManager {
    private DeliveryPersonManager dpm;
    private OrderManager om, gom;
    private EmployeeSettingsSubmenu ess;
    private DeliveryPerson deliveryPerson;
    private SystemSettingsSubmenu sss;
    private Scanner input = new Scanner(System.in);
    
    public EmployeeSubmenuManager(DeliveryPersonManager dpm, DeliveryPerson deliveryPerson, OrderManager gom, 
            Menu menu, Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this.dpm = dpm;
        this.gom = gom;
        this.om = deliveryPerson.getOrderHistory();
        this.deliveryPerson = deliveryPerson;
        this.ess = new EmployeeSettingsSubmenu(this.dpm, this.deliveryPerson.getID());
        this.sss = new SystemSettingsSubmenu(restaurant, menu, inventory, cc, input);
    }
    
    public void showAvailableOrders() {
        if(gom.showAvaliableOrders()){
            char yesNo;
            int choice;
            
            System.out.print("Would you like to take on any of these orders? y/n: ");
            yesNo = input.nextLine().charAt(0);
            
            if(yesNo == 'y'){
                
                System.out.print("Enter the ID of the order you wish to take: ");
                choice = input.nextInt();
                
                Order order = gom.searchOrder(choice);
                
                if(order != null){
                    order.setDeliveryPerson(deliveryPerson);
                    om.addOrder(order);
                    System.out.println("You have been assigned Order #" + order.getOrderId() + "\n");
                }
                else{
                    System.out.println("That order does not exitst.\n");
                }
            }
            else{
                System.out.println("Returning to previous...\n");
            }
            
        }
    }
    
    public void showOrderAssignments(){
        if(om.showUnfulfilledOrders()){
            char yesNo;
            int choice;
            
            System.out.print("Have you fulfilled any of these orders yet? y/n: ");
            yesNo = input.nextLine().charAt(0);
            
            if(yesNo == 'y'){
                
                System.out.print("Enter the ID of the order you have fulfilled: ");
                choice = input.nextInt();
                
                Order order = gom.searchOrder(choice);
                
                if(order != null){
                    order.setFulfillment(true);
                    System.out.println("Order #" + order.getOrderId() + " has been fulfilled!\n");
                }
            }
            else{
                System.out.println("Returning to previous...\n");
            }
        }
    }
    
    public void showOrderHistory(){
        om.showOrderHistory();
    }
    
    public void systemSettings(){
        sss.showMenu();
    }
    
    public void profileSettings(){
        ess.showMenu();
    }

}
