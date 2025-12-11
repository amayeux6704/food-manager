
import java.util.Scanner;

/**
 * This class provides a command line interface menu for an employee user to 
 * edit the information associated with their profile.
 * 
 * @author Alexander
 */
public class EmployeeSettingsSubmenu implements ProgramMenu{
    
    /**
     * The employee settings manager that manages all of the functionality of 
     * this settings sub menu.
     */
    private EmployeeSettingsManager estm;
    
    /**
     * The delivery person manager being used throughout the system.
     */
    private DeliveryPersonManager dpm;
    
    /**
     * The delivery person who is logged in to the system.
     */
    private DeliveryPerson employee;
    
    /**
     * The instance of the phone sub menu to manage phone number information.
     */
    private PhoneSubmenu ps;
    
    /**
     * The instance of the vehicle sub menu to manage the delivery person's 
     * vehicle information.
     */
    private VehicleSubmenu vs;
    
    /**
     * The ID associated with the employee logged in to the system.
     */
    private int employeeId;
    
    /**
     * Class constructor that initializes the instance variables. It initializes
     * the dpm and employeeId variables based on their respective input
     * parameters. The delivery person associated with the input employee ID is
     * assigned to the deliveryPerson variable. The estm variable is initialized 
     * to a new EmployeeSettingsManager() object, passing the dpm as the 
     * argument. The ps is initialized to a new PhoneSubmenu() object, passing 
     * the deliveryPerson as an argument. And finally, the vs is initialized to 
     * a new VehicleSubmenu object, also passing the deliveryPerson as the 
     * argument.
     * 
     * @param dpm   The delivery person manager that is being used throughout 
     *              the entire system.
     * @param id    The ID associated with the employee that is logged in.
     */
    public EmployeeSettingsSubmenu(DeliveryPersonManager dpm, int id){
        this.dpm = dpm;
        employeeId = id;
        employee = dpm.searchDeliveryPerson(id);
        estm = new EmployeeSettingsManager(this.dpm);
        ps = new PhoneSubmenu(this.employee);
        vs = new VehicleSubmenu(employee);
    }
    
    /**
     * This method displays the employee settings sub menu to the user. If the 
     * employee decides to delete their profile, the menu will automatically 
     * return back to the employee sub menu, which will then return to the 
     * employee entry sub menu.
     */
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Settings\n"+
                               "______________________________________________\n"+
                               "1. View Employee Information\n"+
                               "2. Update Name\n"+
                               "3. Update Email Address\n"+
                               "4. Update Password\n"+
                               "5. Manage Vehicle\n"+
                               "6. Manage Phone Numbers\n"+
                               "7. Delete Account\n" +
                               "8. Return to Previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            
            switch (choice){
                case 1:
                    estm.showEmployeeInfo(employeeId);
                    break;
                case 2:
                    estm.updateName(employeeId);
                    break;
                case 3:
                    estm.updateEmail(employeeId);
                    break;
                case 4:
                    estm.updatePassword(employeeId);
                    break;
                case 5:
                    vs.showMenu();
                    break;
                case 6:
                    ps.showMenu();
                    break;
                case 7:
                    estm.removeEmployee(employeeId);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 8 && dpm.searchDeliveryPerson(employeeId) != null);
    }
}
