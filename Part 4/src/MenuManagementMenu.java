/** The menu for navigating menu management tasks
 * @author Brendan Casey
*/
import java.util.Scanner;

public class MenuManagementMenu {
    private Menu menu;
    private Scanner scanner;

    public MenuManagementMenu(Menu menu, Scanner scanner){
        this.menu = menu;
        this.scanner = scanner;
    }
/** Shows a menu for navigating menu management tasks
 */
    public void showMenu(){
        while (true){
            System.out.println("\n--- Menu Management Menu ---");
            System.out.println("1. Manage Dishes");
            System.out.println("2. Manage Sides");
            System.out.println("3. View Menu");
            System.out.println("4. Return");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    new DishManagementMenu(menu, scanner).showMenu();
                    break;
                case 2:
                    new SideManagementMenu(menu, scanner).showMenu();
                    break;
                case 3: 
                    menu.menuDisplay();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
