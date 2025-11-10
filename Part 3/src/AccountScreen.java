import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class AccountScreen {
    
    private CustomerManager cm;
    
    public AccountScreen(CustomerManager cm){
        this.cm = cm;
    }
    
    public Customer logIn(){
        Scanner input = new Scanner(System.in);
        System.out.println("Account Login\n"+
                           "______________________________________________");
        String email, password;
        
        System.out.print("Please enter your email address: ");
        email = input.next();
        
        System.out.print("Please enter your password: ");
        password = input.next();
        
        Customer customer = cm.searchCustomer(email, password);
        
        if(customer != null){
            System.out.println("Successfully logged in!\n");
            return customer;
        }
        else{
            System.out.println("Incorrect email or password.\n");
            return null;
        }
    }
    
    public Customer signUp(){
        Scanner input = new Scanner(System.in);
        
        Customer customer;
        
        String name, email, password;
        
        System.out.println("Account Sign Up\n"+
                           "______________________________________________");
        
        System.out.print("Please enter your name: ");
        name = input.nextLine();
        
        System.out.print("Please enter your email address: ");
        email = input.nextLine();
        
        System.out.print("Please enter a new password: ");
        password = input.nextLine();
        
        
        if(cm.searchCustomer(email) == null){
            customer = new Customer(name, 100/*Placeholder ID*/, false);
            
            customer.setEmail(email);
            customer.setPassword(password);
            
            cm.addCustomer(customer);
            
            System.out.println("Account has been successfully created!\n");
            return customer;
        }
        else{
            System.out.println("A customer associated with this email address already exists.\n");
            return null;
        }
    }
    
    public Customer guest(){
        return new Customer("Guest", 101/*Placeholder ID*/, true);
    }
}
