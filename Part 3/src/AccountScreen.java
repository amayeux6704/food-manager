import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class AccountScreen {
    
    public void getCredentials(Queue<String> credentials){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter your email address: ");
        credentials.add(input.next());
        
        System.out.print("Please enter your password: ");
        credentials.add(input.next());
    }
    
    public Customer logIn(CustomerManager cm){
        Scanner input = new Scanner(System.in);
        System.out.println("Account Login\n"+
                           "______________________________________________");
        
        String email, password;
        
        Queue<String> credentials = new LinkedList<>();
        
        getCredentials(credentials);
        
        email = credentials.remove();
        password = credentials.remove();
        
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
    
    public DeliveryPerson logIn(DeliveryPersonManager dpm){
        Scanner input = new Scanner(System.in);
        System.out.println("Account Login\n"+
                           "______________________________________________");
        
        String email, password;
        
        Queue<String> credentials = new LinkedList<>();
        
        getCredentials(credentials);
        
        email = credentials.remove();
        password = credentials.remove();
        
        DeliveryPerson deliveryPerson = dpm.searchDeliveryPerson(email, password);
        
        if(deliveryPerson != null){
            System.out.println("Successfully logged in!\n");
            return deliveryPerson;
        }
        else{
            System.out.println("Incorrect email or password.\n");
            return null;
        }
    }
    
    public Customer signUp(CustomerManager cm){
        Scanner input = new Scanner(System.in);
        
        Customer customer;
        
        String name, email, password;
        
        System.out.println("Account Sign Up\n"+
                           "______________________________________________");
        
        System.out.print("Please enter your name: ");
        name = input.nextLine();
        
        Queue<String> credentials = new LinkedList<>();
        
        getCredentials(credentials);
        
        email = credentials.remove();
        password = credentials.remove();
        
        if(cm.searchCustomer(email) == null){
            IDGenerator idgen = new IDGenerator();
            
            int id = idgen.generateId(cm, false);
            customer = new Customer(name, id, false);
            
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
    
    public DeliveryPerson signUp(DeliveryPersonManager dpm){
        Scanner input = new Scanner(System.in);
        
        DeliveryPerson deliveryPerson;
        
        String name, email, password;
        
        System.out.println("Create New Employee Profile\n"+
                           "______________________________________________");
        
        System.out.print("Please enter your name: ");
        name = input.nextLine();
        
        Queue<String> credentials = new LinkedList<>();
        
        getCredentials(credentials);
        
        email = credentials.remove();
        password = credentials.remove();
        
        if(dpm.searchDeliveryPerson(email) == null){
            IDGenerator idgen = new IDGenerator();
            
            int id = idgen.generateId(dpm);
            deliveryPerson = new DeliveryPerson(name, id);
            
            deliveryPerson.setEmail(email);
            deliveryPerson.setPassword(password);
            
            dpm.addDeliveryPerson(deliveryPerson);
            
            System.out.println("Account has been successfully created!\n");
            return deliveryPerson;
        }
        else{
            System.out.println("An employee associated with this email address already exists.\n");
            return null;
        }
    }
    
    public Customer guest(CustomerManager cm){
 
        IDGenerator idgen = new IDGenerator();
            
        int id = idgen.generateId(cm, false);
        Customer guest = new Customer("Guest", id, true);
        
        cm.addCustomer(guest);
        return guest;
    }
}
