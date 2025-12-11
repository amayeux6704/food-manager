
import java.util.Scanner;

/**
 * This class provides a command line interface menu for an employee user to 
 * manage the information about their delivery vehicle that they have stored on 
 * their profile.
 * @author Alexander
 */
public class VehicleSubmenu implements ProgramMenu{
    
    /**
     * The instance of the vehicle sub menu manager that manages all of the 
     * functionality of this sub menu. 
     */
    private VehicleSubmenuManager vsm;
    
    /**
     * Class constructor that initializes the vsm variable to a new 
     * VehicleSubmenuManager object, passing the delivery person as the argument 
     * to the constructor.
     * 
     * @param dp The delivery person user who is currently logged in.
     */
    public VehicleSubmenu(DeliveryPerson dp){
        vsm = new VehicleSubmenuManager(dp);
    }
    
    /**
     * This method displays the manage delivery vehicle sub menu to the user.
     */
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Manage Delivery Vehicle:\n"+
                               "______________________________________________\n"+
                               "1. Show Vehicle Information\n"+
                               "2. Add Vehicle\n" +
                               "3. Edit Vehicle\n" +
                               "4. Remove Vehicle\n" +
                               "5. Return to Previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    vsm.showVehicleInfo();
                    break;
                case 2:
                    vsm.addVehicle();
                    break;
                case 3:
                    vsm.editVehicle();
                    break;
                case 4:
                    vsm.removeVehicle();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 5);
    }
}
