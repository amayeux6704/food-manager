
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class VehicleSubmenu implements ProgramMenu{
    
    private VehicleSubmenuManager vsm;
    
    public VehicleSubmenu(DeliveryPerson dp){
        vsm = new VehicleSubmenuManager(dp);
    }
    
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
