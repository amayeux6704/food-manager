
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class EditVehicleSubmenu implements ProgramMenu{
    
    private EditVehicleSubmenuManager evsm;
    
    public EditVehicleSubmenu(Vehicle vehicle){
        evsm = new EditVehicleSubmenuManager(vehicle);
    }
    
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
