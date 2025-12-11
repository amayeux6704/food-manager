
import java.util.Scanner;

/**
 * This class provides a command line interface menu for a user to interact with 
 * the system as a customer.
 * 
 * @author Alexander
 */
public class CustomerSubmenu implements ProgramMenu{
    
    /**
     * The customer sub menu manager that manages all of the functionality of 
     * this customer sub menu.
     */
    private CustomerSubmenuManager csubm;
    
    /**
     * The customer manager being used throughout the system.
     */
    private CustomerManager cm;
    
    /**
     * The customer who is logged in to the system.
     */
    private Customer customer;
    
    /**
     * The ID associated with the customer logged in to the system.
     */
    private int customerId;
    
    /**
     * Class constructor that initializes the instance variables based on the 
     * input parameters. It sets the cm and customerId based on the respective
     * input parameters. It also assigns the customer associated with the 
     * customer id to the customer variable. Finally, it initializes the
     * csubm variable as a new CustomerSubmenuManager object, passing the
     * cm, customer, gom, menu, restaurant, inventory, and cc parameters as
     * arguments to the constructor.
     * 
     * @param cm    The customer manager that is to be used throughout the whole
     *              system.
     * @param id    The ID associated with the customer that is logged in.
     * @param gom   The general order manager that stores and manages all of the
     *              orders within the system.
     * @param menu  The food menu to be used throughout the entire program.
     * @param restaurant    The restaurant that sells the food in the system.
     * @param inventory     The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public CustomerSubmenu(CustomerManager cm, int id, OrderManager gom, Menu menu, 
            Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this.cm = cm;
        customerId = id;
        customer = this.cm.searchCustomer(customerId);
        csubm = new CustomerSubmenuManager(this.cm, customer, gom, menu, restaurant, inventory, cc);
    }
    
    /**
     * This method displays the customer sub menu to the user. If the customer
     * decides to delete their profile, the menu will automatically return back
     * to the customer entry sub menu.
     */
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
