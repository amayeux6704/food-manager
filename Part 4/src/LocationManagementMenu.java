/** The menu for navigating location management tasks
 * @author Brendan Casey
*/
import java.util.Scanner;
import java.util.Set;

public class LocationManagementMenu {
    private Scanner scanner;
    private Restaurant restaurant;

    public LocationManagementMenu(Scanner scanner, Restaurant restaurant){
        this.scanner = scanner;
        this.restaurant = restaurant;
    }

/** Shows a menu for navigating location management tasks
 */
    public void showMenu(){
        while (true){
            System.out.println("\n--- Location Management Menu ---");
            System.out.println("1. Add Location");
            System.out.println("2. Update Location");
            System.out.println("3. Remove Location");
            System.out.println("4. View Locations");
            System.out.println("5. Return to Restaurant Management Menu");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter new location: ");
                    restaurant.addLocation(scanner.nextLine());
                    System.out.println("Added location");
                    break;
                case 2:
                    System.out.print("Enter old location: ");
                    String oldLocation = scanner.nextLine();
                    System.out.print("Enter new location: ");
                    String newLocation = scanner.nextLine();
                    restaurant.updateLocation(oldLocation, newLocation);
                    break;
                case 3:
                    System.out.print("Enter the location you would like to remove: ");
                    restaurant.removeLocation(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Current locations: ");
                    Set<String> locations = restaurant.getLocations();
                    if(locations.isEmpty()){
                        System.out.println("No Locations currently");
                    } else {
                        for (String location : locations){
                            System.out.println("- " + location);
                        }
                    }
                    break;
                case 5:
                    return;
                default :
                    System.out.println("Invalid selection");
            }
        }  
    }
}
