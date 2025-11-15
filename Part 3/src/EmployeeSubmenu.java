
import java.util.Scanner;


/**
 *
 * @author Alexander
 */
public class EmployeeSubmenu implements ProgramMenu{
    
    private EmployeeSubmenuManager esubm;
    private DeliveryPersonManager dpm;
    private DeliveryPerson deliveryPerson;
    private int employeeId;
    
    public EmployeeSubmenu(DeliveryPersonManager dpm, int id, OrderManager gom){
        this.dpm = dpm;
        employeeId = id;
        deliveryPerson = dpm.searchDeliveryPerson(employeeId);
        esubm = new EmployeeSubmenuManager(dpm, deliveryPerson, gom);
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Welcome, " + deliveryPerson.getName()+ "!\n"+
                               "What would you like to do today?\n"+
                               "______________________________________________\n"+
                               "1. View Avaliable Orders for Delivery\n"+
                               "2. View Current Order Assignments\n"+
                               "3. View Order History\n" +
                               "4. Menu Settings\n" +
                               "5. Go to Profile Settings\n" +
                               "6. Logout\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    esubm.showAvailableOrders();
                    break;
                case 2:
                    esubm.showOrderAssignments();
                    break;
                case 3:
                    esubm.showOrderHistory();
                    break;
                case 4:
                    esubm.menuSettings();
                    break;
                case 5:
                    esubm.profileSettings();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 6 && dpm.searchDeliveryPerson(employeeId) != null);
    }
}
