
import java.util.Scanner;

/**
 * This class provides a command line interface main menu for the program. It is 
 * used to give the user the option to enter either as a customer or an employee.
 * @author Alexander
 */
public class MainMenu implements ProgramMenu{
    
    private DeliveryPersonManager dpm;
    /**
     * The instance of the customer entry sub menu.
     */
    private CustomerEntrySubmenu ces;
    
    /**
     * The instance of the customer entry sub menu.
     */
    private EmployeeEntrySubmenu ees;
    
    /**
     * Class constructor that initializes the instances of the customer and 
     * employee entry sub menus. It passes the customer manager, delivery 
     * person manager general order manager, menu, restaurant, inventory, and
     * cost calculation parameters as arguments to the ces and ees variables.
     * 
     * @param cm         The customer manager being used throughout the system.
     * @param dpm        The delivery person manager being used throughout the
     * @param gom        The general order manager that stores and manages all of the
     *                   orders within the system.
     * @param menu       The food menu to be used throughout the entire program.
     * @param restaurant The restaurant that sells the food in the system.
     * @param inventory  The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public MainMenu(CustomerManager cm, DeliveryPersonManager dpm, OrderManager gom, 
            Menu menu, Restaurant restaurant, Inventory inventory, CostCalculation cc){
        ces = new CustomerEntrySubmenu(cm, gom, menu, restaurant, inventory, cc);
        ees = new EmployeeEntrySubmenu(dpm, gom, menu, restaurant, inventory, cc);
    }
    
    /**
     * This method shows the main menu to the user.
     */
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Main Menu:\n"+
                               "______________________________________________\n"+
                               "1. Enter as Customer/Guest \n"+
                               "2. Enter as Employee\n" +
                               "3. Exit\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    ces.showMenu();
                    break;
                case 2:
                    ees.showMenu();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 3);
    }
}
