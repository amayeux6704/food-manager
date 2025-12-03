import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This class manages logging in to and signing up for accounts in the system.
 * It handles logging in and creating new profiles for both customers and
 * employees. It also adds guest profiles to the system for users who do not
 * want to have an account for the system yet.
 * 
 * @author Alexander
 */
public class AccountManager {
    
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
    
    public Customer logIn(UserEntryMenuGUI customerEntry, CustomerManager cm, String email, String password){
        
        Customer customer = cm.searchCustomer(email, password);
        
        if(customer != null){
            JOptionPane.showMessageDialog(customerEntry, "Successfully logged in!");
            return customer;
        }
        else{
            JOptionPane.showMessageDialog(customerEntry, "Incorrect email or password.");
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
    
    public DeliveryPerson logIn(UserEntryMenuGUI employeeEntry, DeliveryPersonManager dpm, String email, String password){
        
        DeliveryPerson deliveryPerson = dpm.searchDeliveryPerson(email, password);
        
        if(deliveryPerson != null){
            JOptionPane.showMessageDialog(employeeEntry,"Successfully logged in!");
            return deliveryPerson;
        }
        else{
            JOptionPane.showMessageDialog(employeeEntry,"Incorrect email or password.");
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
    
    public Customer signUp(UserEntryMenuGUI customerEntry, CustomerManager cm, String name, String email, String password){
        
        Customer customer;
        
        if(cm.searchCustomer(email) == null){
            IDGenerator idgen = new IDGenerator();
            
            int id = idgen.generateId(cm, false);
            customer = new Customer(name, id, false);
            
            customer.setEmail(email);
            customer.setPassword(password);
            
            cm.addCustomer(customer);
            
            JOptionPane.showMessageDialog(customerEntry, "Account has been successfully created!");
            return customer;
        }
        else{
            JOptionPane.showMessageDialog(customerEntry, "A customer associated with this email address already exists.");
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
    
    public DeliveryPerson signUp(UserEntryMenuGUI employeeEntry, DeliveryPersonManager dpm, String name, String email, String password){
        
        DeliveryPerson deliveryPerson;
        
        if(dpm.searchDeliveryPerson(email) == null){
            IDGenerator idgen = new IDGenerator();
            
            int id = idgen.generateId(dpm);
            deliveryPerson = new DeliveryPerson(name, id);
            
            deliveryPerson.setEmail(email);
            deliveryPerson.setPassword(password);
            
            dpm.addDeliveryPerson(deliveryPerson);
            
            JOptionPane.showMessageDialog(employeeEntry,"Account has been successfully created!\n");
            return deliveryPerson;
        }
        else{
            JOptionPane.showMessageDialog(employeeEntry,"A customer associated with this email address already exists.\n");
            return null;
        }
    }
    
    public Customer guest(CustomerManager cm){
 
        IDGenerator idgen = new IDGenerator();
            
        int id = idgen.generateId(cm, true);
        Customer guest = new Customer("Guest", id, true);
        guest.setEmail(String.valueOf(id));
        
        cm.addCustomer(guest);
        return guest;
    }
}
