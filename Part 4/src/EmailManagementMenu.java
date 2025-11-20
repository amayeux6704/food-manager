import java.util.Scanner;
import java.util.Set;

public class EmailManagementMenu {
    private Scanner scanner;
    private Restaurant restaurant;

    public EmailManagementMenu(Scanner scanner, Restaurant restaurant){
        this.scanner = scanner;
        this.restaurant = restaurant;
    }

    public void showMenu(){
        while (true){
            System.out.println("\n--- Email Management Menu ---");
            System.out.println("1. Add email");
            System.out.println("2. Update email");
            System.out.println("3. Remove email");
            System.out.println("4. View emails");
            System.out.println("5. Return to Restaurant Management Menu");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter new email: ");
                    restaurant.addEmail(scanner.nextLine());
                    System.out.println("Added email");
                    break;
                case 2:
                    System.out.print("Enter old email: ");
                    String oldEmail = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    restaurant.updateEmail(newEmail, oldEmail);
                    break;
                case 3:
                    System.out.print("Enter the email you would like to remove: ");
                    restaurant.removeEmail(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Current emails: ");
                    Set<String> emailAddresses = restaurant.getEmails();
                    if(emailAddresses.isEmpty()){
                        System.out.println("No emails currently");
                    } else {
                        for (String emailAddress : emailAddresses){
                            System.out.println("- " + emailAddress);
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
