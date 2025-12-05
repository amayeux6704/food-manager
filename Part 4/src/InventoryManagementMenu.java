/** The menu for navigating inventory management tasks
 * @author Brendan Casey
*/
import java.util.Scanner;

public class InventoryManagementMenu {
    private Scanner scanner;
    private Inventory inventory;

    public InventoryManagementMenu(Inventory inventory, Scanner scanner){
        this.scanner = scanner;
        this.inventory = inventory;
    }

/** Shows a menu for navigating inventory management tasks
 */
    public void showMenu(){
        while (true){
            System.out.println("\n--- Inventory Management Menu ---");
            System.out.println("1. Update item quantity");
            System.out.println("2. Decrease item quantity");
            System.out.println("3. View inventory");
            System.out.println("4. Return");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter items name: ");
                    String aName = scanner.nextLine();
                    System.out.print("Enter how much to add to items quantity: ");
                    int aQuantity = scanner.nextInt();
                    scanner.nextLine();
                    inventory.addOrUpdateItem(aName, aQuantity);
                    break;
                case 2:
                    System.out.print("Enter items to decreases name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Enter how much to decrease the item by: ");
                    int dQuantity = scanner.nextInt();
                    scanner.nextLine();
                    inventory.decreaseInventory(dName, dQuantity);
                    break;
                case 3: 
                    inventory.displayInventory();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
