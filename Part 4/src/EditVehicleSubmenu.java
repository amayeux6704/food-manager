
import java.util.Scanner;

/**
 * This class provides a command line interface menu for an employee user to 
 * edit the information about their delivery vehicle that they have stored on 
 * their profile.
 * @author Alexander
 */
public class EditVehicleSubmenu implements ProgramMenu{
    
    /**
     * The instance of the edit vehicle sub menu manager that manages all of the 
     * functionality of this sub menu. 
     */
    private EditVehicleSubmenuManager evsm;
    
    /**
     * Class constructor that initializes the evsm variable to a new 
     * EditVehicleSubmenuManager object, passing the vehicle as the argument 
     * to the constructor.
     * 
     * @param vehicle   The vehicle that is being edited by the user.
     */
    public EditVehicleSubmenu(Vehicle vehicle){
        evsm = new EditVehicleSubmenuManager(vehicle);
    }
    
    /**
     * This method displays the edit delivery vehicle sub menu to the user.
     */
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Edit Delivery Vehicle:\n"+
                               "______________________________________________\n"+
                               "1. Change Year\n"+
                               "2. Change Make\n" +
                               "3. Change Model\n" +
                               "4. Change Color\n" +
                               "5. Change Body Style\n"+
                               "6. Update License Plate Number\n"+
                               "7. Return to Previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    evsm.changeYear();
                    break;
                case 2:
                    evsm.changeMake();
                    break;
                case 3:
                    evsm.changeModel();
                    break;
                case 4:
                    evsm.changeColor();
                    break;
                case 5:
                    evsm.changeBodyStyle();
                    break;
                case 6:
                    evsm.updateLicensePlate();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 7);
    }
}
