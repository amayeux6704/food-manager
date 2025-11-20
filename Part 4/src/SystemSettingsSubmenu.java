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
    private Scanner scanner;
    
    public SystemSettingsSubmenu(Restaurant restaurant, Menu menu, Inventory inventory,
            CostCalculation costCalculation, Scanner scanner){
        this.restaurant = restaurant;
        this.menu = menu;
        this.inventory = inventory;
        this.costCalculation = costCalculation;
        this.scanner = scanner;
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        while(true){
            System.out.print("Food Delivery Management System Settings\n"+
                               "______________________________________________\n"+
                               "1. Manage Restaurant Information\n"+
                               "2. Manage Menu\n"+
                               "3. Manage Inventory\n" +
                               "4. Manage Cost Settings\n" +
                               "5. Return to Employee Submenu\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = scanner.nextByte();
            scanner.nextLine();
            System.out.println("");
            
            switch(choice){
                case 1:
                    new RestaurantManagementMenu(restaurant, scanner).showMenu();
                    break;
                case 2:
                    new MenuManagementMenu(menu, scanner).showMenu();
                    break;
                case 3:
                    new InventoryManagementMenu(inventory, scanner).showMenu();
                    break;
                case 4:
                    new CostCalculationMenu(costCalculation, scanner).showMenu();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("That choice was invalid..." + "Please try again.");
                    break;
            }
        }
    }
}
