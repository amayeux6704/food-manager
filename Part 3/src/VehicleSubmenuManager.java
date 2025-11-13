
import java.util.Scanner;


/**
 *
 * @author Alexander
 */
public class VehicleSubmenuManager {
    
    private DeliveryPerson dp;
    private EditVehicleSubmenu evs;
    
    public VehicleSubmenuManager(DeliveryPerson dp){
        this.dp = dp;
    }
    
    public void showVehicleInfo(){
        Vehicle vehicle = dp.getDeliveryVehicle();
        
        if(vehicle != null){
            System.out.println(vehicle);
        }
        else{
            System.out.println("You do not have a vehicle assigned to your profile.\n");
        }
    }
    
    public void addVehicle(){
        if(dp.getDeliveryVehicle() != null){
            System.out.println("You already have a vehicle assigned to your profile.\n");
        }
        else{
            Scanner input = new Scanner(System.in);
        
            Vehicle vehicle = new Vehicle(dp, 100);
        
            System.out.print("Please enter the year of your car: ");
            vehicle.setYear(input.nextShort());
            
            input.nextLine();
            
            System.out.print("Please enter the make of your car: ");
            vehicle.setMake(input.nextLine());
        
            System.out.print("Please enter the model of your car: ");
            vehicle.setModel(input.nextLine());
        
            System.out.print("Please enter the color of your car: ");
            vehicle.setColor(input.nextLine());
        
            System.out.print("Please enter the body style of your car\n"
                    + "(ie Sedan, Truck, etc): ");
            vehicle.setBodyStyle(input.nextLine());
            
            System.out.print("Please enter your license plate number: ");
            vehicle.setLicensePlate(input.nextLine());
        
            dp.setDeliveryVehicle(vehicle);
            System.out.println("Your vehicle has been successfully added!\n");
        }
    }
    
    public void editVehicle(){
        Vehicle vehicle = dp.getDeliveryVehicle();
        if(vehicle == null){
            System.out.println("You do not have a vehicle assigned to your profile.\n");
        }
        else{
            evs = new EditVehicleSubmenu(vehicle);
            evs.showMenu();
        }
    }
    
    public void removeVehicle(){
        Vehicle vehicle = dp.getDeliveryVehicle();
        if(vehicle == null){
            System.out.println("You do not have a vehicle assigned to your profile.\n");
        }
        else{
            Scanner input = new Scanner(System.in);
            System.out.print("Are you sure you want to remove your vehicle? y/n: ");
            char choice = input.nextLine().charAt(0);
            
            if(choice == 'y'){
                dp.setDeliveryVehicle(null);
                System.out.println("Vehicle has been removed successfully.\n"); 
            }
            else{
                System.out.println("Operation cancelled.\n");
            }
        }
    }
}
