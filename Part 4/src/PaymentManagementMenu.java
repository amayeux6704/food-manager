/** The menu for navigating payment method management tasks
 * @author Brendan Casey
*/
import java.util.Scanner;

public class PaymentManagementMenu {
    private Scanner scanner;
    private Payment payment;

    public PaymentManagementMenu(Payment payment, Scanner scanner){
        this.scanner = scanner;
        this.payment = payment;
    }

/** Displays the menu for managing payment methods
 */
    public void showMenu(){
        while (true){
            System.out.println("\n--- Payment Management Menu ---");
            System.out.println("Current payment method: " + payment.getCurrentPayMethod());
            System.out.println("1. Add new payment method");
            System.out.println("2. Remove payment method");
            System.out.println("3. Set payment method");
            System.out.println("4. View payment methods");
            System.out.println("5. Return");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter new payment method name: ");
                    payment.addPayMethod(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter the name of the payment method you desire to remove: ");
                    payment.removePayMethod(scanner.nextLine());
                    break;
                case 3: 
                    System.out.print("Enter the payment method you would like to set as your current payment method: ");
                    payment.setCurrentPayMethod(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("\n--- Payment Methods---");
                    if(payment.getPayMethods().isEmpty()) {
                        System.out.println("No payment methods saved");
                    } else {
                        for (String method : payment.getPayMethods()){
                            System.out.println(method);
                        } 
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
