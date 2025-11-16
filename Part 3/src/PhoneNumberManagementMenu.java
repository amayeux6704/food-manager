import java.util.Scanner;
import java.util.Set;

public class PhoneNumberManagementMenu {
    private Scanner scanner;
    private Restaurant restaurant;

    public PhoneNumberManagementMenu(Scanner scanner, Restaurant restaurant){
        this.scanner = scanner;
        this.restaurant = restaurant;
    }

    public void showMenu(){
        while (true){
            System.out.println("\n--- Phone Number Management Menu ---");
            System.out.println("1. Add phone number");
            System.out.println("2. Update phone number");
            System.out.println("3. Remove phone number");
            System.out.println("4. View phone numbers");
            System.out.println("5. Return to Restaurant Management Menu");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter new phone number: ");
                    restaurant.addPhoneNumber(scanner.nextLine());
                    System.out.println("Added phone number");
                    break;
                case 2:
                    System.out.print("Enter old phone number: ");
                    String oldPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    restaurant.updatePhoneNumber(oldPhoneNumber, newPhoneNumber);
                    break;
                case 3:
                    System.out.print("Enter the phone number you would like to remove: ");
                    restaurant.removePhoneNumber(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Current phone numbers: ");
                    Set<String> contacts = restaurant.getPhoneNumbers();
                    if(contacts.isEmpty()){
                        System.out.println("No phone numbers currently");
                    } else {
                        for (String contact : contacts){
                            System.out.println("- " + contact);
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
