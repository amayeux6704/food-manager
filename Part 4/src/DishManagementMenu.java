/** The menu for navigating dish management tasks
 * @author Brendan Casey
*/
import java.util.Scanner;

public class DishManagementMenu {
    private Menu menu;
    private Scanner scanner;

    public DishManagementMenu(Menu menu, Scanner scanner){
        this.menu = menu;
        this.scanner = scanner;
    }

/** Shows a menu for navigating dish management tasks
 */
    public void showMenu(){
        while (true){
            System.out.println("\n--- Dish Management Menu ---");
            System.out.println("1. Add dish");
            System.out.println("2. Remove dish");
            System.out.println("3. Update dish name");
            System.out.println("4. Update dish price");
            System.out.println("5. Manage dish Recipe");
            System.out.println("6. View dish list");
            System.out.println("7. Return to menu management");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter dish name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter dish price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    menu.addDish(name, price);
                    break;
                case 2:
                    System.out.print("Enter dish ID for the dish you would like to remove: ");
                    menu.removeDish(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3: 
                    System.out.print("Enter dish ID to update name: ");
                    int dishID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name:");
                    String newName = scanner.nextLine();
                    menu.updateDishName(dishID, newName);
                    break;
                case 4:
                    System.out.print("Enter dish ID to update price: ");
                    int aDishID = scanner.nextInt();      
                    scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double aPrice = scanner.nextDouble();
                    scanner.nextLine();
                    menu.updateDishPrice(aDishID, aPrice);
                    break;
                case 5:
                    System.out.println("Enter the dishes ID to manage its recipe: ");
                    int theDishID = scanner.nextInt(); 
                    scanner.nextLine();
                    Dish dish = menu.findDish(theDishID);               
                    new IngredientManagementMenu(dish.getRecipe(), scanner).showMenu();
                    break;
                case 6:
                    menu.DishDisplay();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
