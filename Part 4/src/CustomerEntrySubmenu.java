
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class CustomerEntrySubmenu implements ProgramMenu{
    
    private CustomerManager cm;
    private CustomerSubmenu cs;
    private AccountManager as;
    private OrderManager gom;
    private Menu menu;
    private Restaurant restaurant;
    private Inventory inventory;
    private CostCalculation cc;
    
    public CustomerEntrySubmenu(CustomerManager cm, OrderManager gom, 
            Menu menu, Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this.cm = cm;
        this.gom = gom;
        this.menu = menu;
        as = new AccountManager();
        this.restaurant = restaurant;
        this.inventory = inventory;
        this.cc = cc;
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Customer Entry:\n"+
                               "______________________________________________\n"+
                               "1. Log In\n"+
                               "2. Sign Up\n"+
                               "3. Order as Guest\n"+
                               "4. Back to Main\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            Customer customer = null;
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    customer = as.logIn(cm);
                    break;
                case 2:
                    customer = as.signUp(cm);
                    break;
                case 3:
                    customer = as.guest(cm);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
            if(customer != null){
                cs = new CustomerSubmenu(cm, customer.getID(), gom, menu, restaurant, inventory, cc);
                cs.showMenu();

            }
        }
        while(choice != 4);
    }
}
