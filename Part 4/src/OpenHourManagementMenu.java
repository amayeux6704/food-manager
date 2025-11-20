import java.util.Scanner;

public class OpenHourManagementMenu {
    private Scanner scanner;
    private Restaurant restaurant;

    public OpenHourManagementMenu(Scanner scanner, Restaurant restaurant){
        this.scanner = scanner;
        this.restaurant = restaurant;
    }

    public void showMenu(){
        while (true){
            System.out.println("\n--- Open Hour Management Menu ---");
            System.out.println("1. Set Opening Hours");
            System.out.println("2. View Opening Hours");
            System.out.println("3. Return to Restaurant Management Menu");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter open hours: ");
                    restaurant.setOpenHours(scanner.nextLine());
                    System.out.println("Open hours have been set");
                    break;
                case 2:
                    System.out.println("Open Hours: " + restaurant.getOpenHours());
                    break;
                case 3:
                    return;
                default :
                    System.out.println("Invalid selection");
            }
        }  
    }
}
