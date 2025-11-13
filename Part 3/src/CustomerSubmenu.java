
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class CustomerSubmenu implements ProgramMenu{
    
    private CustomerSettingsSubmenu css;
    private CustomerSubmenuManager csubm;
    private CustomerManager cm;
    private Customer customer;
    private Menu menu;
    private int customerId;
    
    public CustomerSubmenu(CustomerManager cm, int id){
        this.cm = cm;
        customerId = id;
        customer = cm.searchCustomer(customerId);
        csubm = new CustomerSubmenuManager(this.cm, customer);
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Welcome, " + customer.getName()+ "!\n"+
                               "What would you like to do today?\n"+
                               "______________________________________________\n"+
                               "1. Place an Order\n"+
                               "2. View Menu\n"+
                               "3. View Current Orders\n" +
                               "4. View Order History\n" +
                               "5. Go to Profile Settings\n" +
                               "6. Logout\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    csubm.placeOrder();
                    break;
                case 2:
                    csubm.viewMenu();
                    csubm.showCurrentOrders();
                    break;
                case 3:
                    csubm.showCurrentOrders();
                    break;
                case 4:
                    csubm.showOrderHistory();
                    break;
                case 5:
                    csubm.profileSettings();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 6 && cm.searchCustomer(customerId) != null);
    }
}
