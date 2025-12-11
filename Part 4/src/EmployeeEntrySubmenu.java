
import java.util.Scanner;

/**
 * This class provides a command line interface for the user to enter the system
 * as an employee. It allows the user to enter their credentials to log in to the 
 * system if they already have an account or create an account if they
 * are not already in the system
 * 
 * @author Alexander
 */
public class EmployeeEntrySubmenu implements ProgramMenu{
    /**
     * The delivery person manager being used throughout the system.
     */
    private DeliveryPersonManager dpm;
    
    /**
     * The instance of the employee sub menu.
     */
    private EmployeeSubmenu es;
    
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
     * Class constructor that initializes the delivery person manager, general 
     * order manager, menu, restaurant, inventory, and cost calculation objects 
     * based on the input parameters. It also initializes am as a new 
     * AccountManager object.
     * 
     * @param dpm   The delivery person manager that is to be used throughout 
     *              the whole system.
     * @param gom   The general order manager that stores and manages all of the
     *              orders within the system.
     * @param menu  The food menu to be used throughout the entire program.
     * @param restaurant    The restaurant that sells the food in the system.
     * @param inventory     The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public EmployeeEntrySubmenu(DeliveryPersonManager dpm, OrderManager gom, Menu menu,
            Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this.dpm = dpm;
        this.gom = gom;
        am = new AccountManager();
        this.menu = menu;
        this.restaurant = restaurant;
        this.inventory = inventory;
        this.cc = cc;
    }
    
    /**
     * This method displays the employee entry sub menu to the user. If the
     * delivery person object that is returned from the account manager object 
     * does not return null, a new instance of the employee sub menu is made and
     * the menu is displayed.
     */
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Employee Entry:\n"+
                               "______________________________________________\n"+
                               "1. Login\n"+
                               "2. Create new Profile\n"+
                               "3. Back to Main\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            DeliveryPerson deliveryPerson = null;
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    deliveryPerson = am.logIn(dpm);
                    break;
                case 2:
                    deliveryPerson = am.signUp(dpm);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
            if(deliveryPerson != null){
                es = new EmployeeSubmenu(dpm, deliveryPerson.getID(), gom, menu, restaurant, inventory, cc);
                es.showMenu();
            }
        }
        while(choice != 3);
    }
}