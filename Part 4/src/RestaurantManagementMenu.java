/** The menu for navigating restaurant management tasks
 * @author Brendan Casey
*/
import java.util.Scanner;
import java.util.Set;

public class RestaurantManagementMenu {
    private Scanner scanner = new Scanner(System.in);
    private Restaurant restaurant = new Restaurant("Template Name");

    public RestaurantManagementMenu(Restaurant restaurant, Scanner scanner){
        this.scanner = scanner;
        this.restaurant = restaurant;
    }
    
/**Displays the menu for managing the restaurant
 */
    public void showMenu(){
        LocationManagementMenu locationManagementMenu = new LocationManagementMenu(scanner, restaurant);
        PhoneNumberManagementMenu phoneNumberManagementMenu = new PhoneNumberManagementMenu(scanner, restaurant);
        EmailManagementMenu emailManagementMenu = new EmailManagementMenu(scanner, restaurant);
        OpenHourManagementMenu openHourManagementMenu = new OpenHourManagementMenu(scanner, restaurant);

        while (true){
            System.out.println("\n --- Restaurant Management Menu ---");
            System.out.println("1. Manage Locations");
            System.out.println("2. Manage Phone Numbers");
            System.out.println("3. Manage Emails");
            System.out.println("4. Manage Opening Hours");
            System.out.println("5. View Restaurant Name");
            System.out.println("6. Change Restaurant Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    locationManagementMenu.showMenu();
                    break;
                case 2:
                    phoneNumberManagementMenu.showMenu();
                    break;
                case 3:
                    emailManagementMenu.showMenu();
                    break;
                case 4:
                    openHourManagementMenu.showMenu();
                    break;
                case 5:
                    System.out.println("Restaurant Name: " + restaurant.getName());
                    break;
                case 6:
                    System.out.print("Enter the new name for the restaurant: ");
                    String newName = scanner.nextLine();
                    restaurant.setName(newName);
                    break;
                case 7:
                    return;
                default :
                    System.out.println("Invalid selection");
            }
        }  
    }
}
