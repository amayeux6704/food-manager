
import java.util.Scanner;


/**
 *
 * @author Alexander
 */
public class EmployeeSubmenu implements ProgramMenu{
    
    private EmployeeSubmenuManager esm;
    private DeliveryPerson deliveryPerson;
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Welcome, " + deliveryPerson.getName()+ "!\n"+
                               "What would you like to do today?\n"+
                               "______________________________________________\n"+
                               "1. Place an Order\n"+
                               "2. View Menu\n"+
                               "3. View Order History\n" +
                               "4. Go to Profile Settings\n" +
                               "5. Logout\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    break;
                case 2:
                    menu.menuDisplay();
                    break;
                case 3:
                    break;
                case 4:
                    css.showMenu();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 5 && cm.searchCustomer(customerId) != null);
    }
}
