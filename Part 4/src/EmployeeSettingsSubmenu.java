
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class EmployeeSettingsSubmenu implements ProgramMenu{
    private EmployeeSettingsManager estm;
    private DeliveryPersonManager dpm;
    private DeliveryPerson employee;
    private PhoneSubmenu ps;
    private VehicleSubmenu vs;
    private int employeeId;
    
    public EmployeeSettingsSubmenu(DeliveryPersonManager dpm, int id){
        this.dpm = dpm;
        employeeId = id;
        employee = dpm.searchDeliveryPerson(id);
        estm = new EmployeeSettingsManager(this.dpm);
        ps = new PhoneSubmenu(this.employee);
        vs = new VehicleSubmenu(employee);
    }
    
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
