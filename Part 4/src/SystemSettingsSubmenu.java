import java.util.Scanner;
/**
 * This class provides a command line interface menu for an employee user to 
 * manage the system settings
 * @author Alexander
 */
public class SystemSettingsSubmenu implements ProgramMenu{
    
    /**
     * The restaurant that sells the food in the system.
     */
    private Restaurant restaurant;
    
    /**
     * The food menu that has all of the food items.
     */
    private Menu menu;
    
    /**
     * The inventory of ingredients for each dish.
     */
    private Inventory inventory;
    
    /**
     * The cost calculation object to be used to calculate the cost of orders
     * and keep a standard tax rate.
     */
    private CostCalculation costCalculation;
    
    /**
     * A scanner to receive user input.
     */
    private Scanner scanner;
    
    /**
     * Class constructor that initializes the instance variables based on their
     * respective input parameters.
     * 
     * @param restaurant      The restaurant that sells the food in the system.
     * @param menu            The food menu to be used throughout the entire 
     *                        program.
     * @param inventory       The inventory of ingredients for each dish
     * @param costCalculation The cost calculation object to calculate the cost 
     *                        of orders and keep a standard tax rate throughout
     *                        the system.
     * @param scanner         A scanner that receives user input.
     */
    public SystemSettingsSubmenu(Restaurant restaurant, Menu menu, Inventory inventory,
            CostCalculation costCalculation, Scanner scanner){
        this.restaurant = restaurant;
        this.menu = menu;
        this.inventory = inventory;
        this.costCalculation = costCalculation;
        this.scanner = scanner;
    }
    
    /**
     * This method displays the food delivery management system settings sub 
     * menu to the user. Each instance of the sub menus are initialized when
     * their options are selected.
     */
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
