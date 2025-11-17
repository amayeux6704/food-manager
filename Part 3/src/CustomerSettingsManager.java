
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class CustomerSettingsManager {
    private CustomerManager customerManager;
    
    public CustomerSettingsManager(CustomerManager customerManager){
        this.customerManager = customerManager;
    }
    
    public void showCustomerInfo(int id){
        Customer customer = customerManager.searchCustomer(id);
        System.out.println(customer);
    }
    
    public void updateName(int id){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter your updated name: ");
        
        String newName = input.nextLine();
        
        Customer customer = customerManager.searchCustomer(id);
        customer.setName(newName);
        
        System.out.println("Your name has been successfully updated!\n");
    }
    
    public void updateEmail(int id){
        Scanner input = new Scanner(System.in);
        char choice;
        Customer customer = customerManager.searchCustomer(id);
        
        System.out.println("Current email address: " + customer.getEmail());
        System.out.print("Are you sure you want to change this email address? y/n: ");
        
        choice = input.nextLine().charAt(0);
        
        if(Character.toLowerCase(choice) == 'y'){
            String newEmail;
            System.out.print("Please enter your updated email address: ");
            newEmail = input.nextLine();
            
            customer.setEmail(newEmail);
            System.out.println("Your email address has been successfully changed!\n");
        }
        else{
            System.out.println("Operation cancelled.\n");
        }
    }
    
    public void updatePassword(int id){
        Scanner input = new Scanner(System.in);
        Customer customer = customerManager.searchCustomer(id);
        
        System.out.print("Please enter your current password: ");
        
        String oldPassword = input.nextLine();
        
        if(customer.getPassword().equals(oldPassword)){
            System.out.print("Please enter your new password: ");
            String newPassword = input.nextLine();
            
            System.out.print("Please re-enter your new password: ");
            String newPassword1 = input.nextLine();
            
            if(newPassword.equals(newPassword1)){
                customer.setPassword(newPassword);
                System.out.println("Your password has been successfully changed!\n");
            }
            else{
                System.out.println("The two passwords do not match.\n");
            }
        }
        else{
            System.out.println("Incorrect password.\n");
        }
    }
    
    public void removeCustomer(int id){
        Scanner input = new Scanner(System.in);
        
        char choice;
        
        System.out.print("Are you sure you want to delete your account?\n" +
                           "This operation cannot be undone. y/n: ");
        
        choice = input.nextLine().charAt(0);
        
        if(choice == 'y' && confirmWithPassword(input, id)){
            customerManager.removeCustomer(id);
            
            System.out.println("Your account has been successfully deleted.\n"+
                               "Now returning to the customer entry menu...\n");
        }
        else{
            System.out.println("Operation cancelled.\n");
        }
    }
    
    public boolean confirmWithPassword(Scanner input, int id){
        
        String confirmPassword1;
        String confirmPassword2;
        
        System.out.print("Please enter your password: ");
        
        confirmPassword1 = input.nextLine();
        
        if(confirmPassword1.equals(customerManager.searchCustomer(id).getPassword())){
            System.out.print("Please enter your password again to confirm: ");
            
            confirmPassword2 = input.nextLine();
            
            if(confirmPassword2.equals(confirmPassword1)){
                System.out.println("Operation Confirmed.");
                return true;
            }
            else{
                System.out.println("The entered passwords do not match.");
                return false;
            }
        }
        else{
            System.out.println("Incorrect password.");
            return false;
        }
    }
}
