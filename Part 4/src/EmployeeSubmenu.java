
import java.util.Scanner;

/**
 * This class provides a command line interface menu for a user to interact with 
 * the system as an employee.
 * @author Alexander
 */
public class EmployeeSubmenu implements ProgramMenu{
    
    /**
     * The employee sub menu manager that manages all of the functionality of 
     * this employee sub menu.
     */
    private EmployeeSubmenuManager esubm;
    
    /**
     * The delivery person manager being used throughout the system.
     */
    private DeliveryPersonManager dpm;
    
    /**
     * The delivery person who is logged in to the system.
     */
    private DeliveryPerson deliveryPerson;
    
    /**
     * The ID associated with the employee logged in to the system.
     */
    private int employeeId;
    
    /**
     * Class constructor that initializes the instance variables based on the 
     * input parameters. It sets the dpm and employeeId based on the respective
     * input parameters. It also assigns the delivery person associated with the 
     * employee id to the deliveryPerson variable. Finally, it initializes the
     * esubm variable as a new EmployeeSubmenuManager object, passing the
     * dpm, deliveryPerson, gom, menu, restaurant, inventory, and cc parameters
     * as arguments to the constructor.
     * 
     * @param dpm   The delivery person manager that is to be used throughout 
     *              the whole system.
     * @param id    The ID associated with the employee that is logged in.
     * @param gom   The general order manager that stores and manages all of the
     *              orders within the system.
     * @param menu  The food menu to be used throughout the entire program.
     * @param restaurant    The restaurant that sells the food in the system.
     * @param inventory     The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public EmployeeSubmenu(DeliveryPersonManager dpm, int id, OrderManager gom, Menu menu,
            Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this.dpm = dpm;
        employeeId = id;
        deliveryPerson = dpm.searchDeliveryPerson(employeeId);
        esubm = new EmployeeSubmenuManager(dpm, deliveryPerson, gom, menu, restaurant, inventory, cc);
    }
    
    /**
     * This method displays the employee sub menu to the user. If the employee
     * decides to delete their profile, the menu will automatically return back
     * to the employee entry sub menu.
     */
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
                               "4. Go to Profile Settings\n" +
                               "5. System Settings\n" +
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
                    esubm.profileSettings();
                    break;
                case 5:
                    esubm.systemSettings();
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
