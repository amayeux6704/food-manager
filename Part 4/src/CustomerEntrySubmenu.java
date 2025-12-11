
import java.util.Scanner;

/**
 * This class provides a command line interface for a user to enter the system 
 * as a customer. It allows the user to enter their credentials to log in to the 
 * system if they already have an account, sign up for a new account if they
 * are not already in the system, or enter as a guest if they do not wish to 
 * create a new account. 
 *
 * @author Alexander
 */
public class CustomerEntrySubmenu implements ProgramMenu{
    
    /**
     * The customer manager being used throughout the system.
     */
    private CustomerManager cm;
    
    /**
     * The instance of the customer sub menu.
     */
    private CustomerSubmenu cs;
    
    /**
     * The account manager object that will handle logging in and creating new
     * profiles for users.
     */
    private AccountManager am;
    
    /**
     * The general order manager that stores and manages all of the
     * orders within the system.
     */
    private OrderManager gom;
    
    /**
     * The food menu to be used throughout the entire system.
     */
    private Menu menu;
    
    /**
     * The restaurant that sells the food in the system.
     */
    private Restaurant restaurant;
    
    /**
     * The inventory of ingredients for each dish to be sold.
     */
    private Inventory inventory;
    
    /**
     * The cost calculation object to calculate the cost of the orders.
     */
    private CostCalculation cc;
    
    /**
     * Class constructor that initializes the customer manager, general order
     * manager, menu, restaurant, inventory, and cost calculation objects based
     * on the input parameters. It also initializes am as a new AccountManager
     * object.
     * 
     * @param cm    The customer manager that is to be used throughout the whole
     *              system.
     * @param gom   The general order manager that stores and manages all of the
     *              orders within the system.
     * @param menu  The food menu to be used throughout the entire program.
     * @param restaurant    The restaurant that sells the food in the system.
     * @param inventory     The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public CustomerEntrySubmenu(CustomerManager cm, OrderManager gom, 
            Menu menu, Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this.cm = cm;
        this.gom = gom;
        this.menu = menu;
        am = new AccountManager();
        this.restaurant = restaurant;
        this.inventory = inventory;
        this.cc = cc;
    }
    
    /**
     * This method displays the customer entry sub menu to the user. If the 
     * customer object that is returned from the account manager object does not
     * return null, a new instance of the customer sub menu is made and the menu
     * is displayed.
     */
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
                    customer = am.logIn(cm);
                    break;
                case 2:
                    customer = am.signUp(cm);
                    break;
                case 3:
                    customer = am.guest(cm);
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
