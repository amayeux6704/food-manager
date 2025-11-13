
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
                               "3. Update Password\n"+
                               "4. Manage Vehicle\n"+
                               "5. Manage Phone Numbers\n"+
                               "6. Delete Account\n" +
                               "7. Return to Previous\n"+
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
                    estm.updatePassword(employeeId);
                    break;
                case 4:
                    vs.showMenu();
                    break;
                case 5:
                    ps.showMenu();
                    break;
                case 6:
                    estm.removeEmployee(employeeId);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 7 && dpm.searchDeliveryPerson(employeeId) != null);
    }
}
