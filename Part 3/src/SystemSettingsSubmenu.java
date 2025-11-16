
import java.util.Scanner;


/**
 *
 * @author Alexander
 */
public class SystemSettingsSubmenu implements ProgramMenu{
    
    private Restaurant restaurant;
    private Menu menu;
    private Inventory inventory;
    private CostCalculation costCalculation;
    
    public SystemSettingsSubmenu(Restaurant restaurant, Menu menu, Inventory inventory, CostCalculation costCalculation){
        this.restaurant = restaurant;
        this.menu = menu;
        this.inventory = inventory;
        this.costCalculation = costCalculation;
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Food Delivery Management System Settings\n"+
                               "______________________________________________\n"+
                               "1. Manage Restaurant Information\n"+
                               "2. Manage Menu\n"+
                               "3. Manage Inventory\n" +
                               "4. Manage Cost Settings\n" +
                               "5. Return to Employee Submenu\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
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
