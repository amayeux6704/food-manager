
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
class EditVehicleSubmenuManager {
    
    private Vehicle vehicle;
    
    public EditVehicleSubmenuManager(Vehicle vehicle){
        
        this.vehicle = vehicle;
    }
    
    public void changeYear(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the new year of your car: ");
        vehicle.setYear(input.nextShort());
        
        System.out.println("Vehicle year has been updated successfully.\n");
    }
    
    public void changeMake(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the new make of your car: ");
        vehicle.setMake(input.nextLine());
        
        System.out.println("Vehicle make has been updated successfully.\n");
    }
    
    public void changeModel(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the new model of your car: ");
        vehicle.setModel(input.nextLine());
        
        System.out.println("Vehicle model has been updated successfully.\n");
    }
    
    public void changeColor(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the new color of your car: ");
        vehicle.setColor(input.nextLine());
        
        System.out.println("Vehicle color has been updated successfully.\n");
    }
    
    public void changeBodyStyle(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the new body style of your car: ");
        vehicle.setBodyStyle(input.nextLine());
        
        System.out.println("Vehicle body has been updated successfully.\n");
    }

    public void updateLicensePlate() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please your updated license plate number: ");
        vehicle.setLicensePlate(input.nextLine());
        
        System.out.println("Vehicle license plate has been updated successfully.\n");
    }
}
