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
    
    /**
     * This method prompts the user to enter their credentials. It then adds
     * these credentials to the credentials Queue parameter to be used to
     * log the user in.
     * 
     * @param credentials A queue that temporarily stores the user's credentials.
     */
    public void getCredentials(Queue<String> credentials){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter your email address: ");
        credentials.add(input.next());
        
        System.out.print("Please enter your password: ");
        credentials.add(input.next());
    }
    
    /**
     * This method logs in a customer user through a command line interface. The 
     * getCredentials() method is called to retrieve the customer's email and
     * password. The method searches for the customer by their email and
     * password, calling the customer manager's searchCustomer() method. If the
     * returned customer is not null, a message is displayed informing the user 
     * that they have successfully logged in, and the customer object associated 
     * with the email and password is returned. Otherwise, a message is 
     * displayed informing the user that they have entered the incorrect email 
     * or password, and a null value is returned.
     * 
     * @param cm    The customer manager that stores all of the information
     *              about the customers in the system.
     * @return      The customer associated with the input email address and 
     *              password if they can be found in the customer manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method logs in a customer user through a GUI. The email and password
     * parameters are used as arguments for the customer manager's 
     * searchCustomer() method to search for the customer. If the returned 
     * customer is not null, a message is displayed informing the user that they 
     * have successfully logged in, and the customer object associated with the 
     * email and password is returned. Otherwise, a message is displayed 
     * informing the user that they have entered the incorrect email or 
     * password, and a null value is returned.
     * 
     * @param customerEntry The GUI user entry menu.
     * @param cm        The customer manager that stores all of the information
     *                  about the customers in the system.
     * @param email     The email entered by the user.
     * @param password  The password entered by the user.
     * @return      The customer associated with the input email address and 
     *              password if they can be found in the customer manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method logs in a delivery person user through a command line 
     * interface. The getCredentials() method is called to retrieve the delivery 
     * person's email and password. The method searches for the delivery person
     * by their email and password, calling the delivery person manager's 
     * searchDeliveryPerson() method. If the returned delivery person is not 
     * null, a message is displayed informing the user that they have 
     * successfully logged in, and the delivery person object associated with 
     * the email and password is returned. Otherwise, a message is displayed 
     * informing the user that they have entered the incorrect email or 
     * password, and a null value is returned.
     * 
     * @param dpm   The delivery person manager that stores all of the 
     *              information about the delivery people in the system.
     * @return      The delivery person associated with the input email address 
     *              and password if they can be found in the delivery person 
     *              manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method logs in a delivery person user through a GUI. The email and 
     * password parameters are used as arguments for the delivery person
     * manager's searchDeliveryPerson() method to search for the employee. If 
     * the returned delivery person is not null, a message is displayed 
     * informing the user that they have successfully logged in, and the
     * delivery person object associated with the email and password is 
     * returned. Otherwise, a message is displayed informing the user that they 
     * have entered the incorrect email or password, and a null value is 
     * returned.
     * 
     * @param employeeEntry The GUI user entry menu.
     * @param dpm       The delivery person manager that stores all of the 
     *                  information about the delivery people in the system.
     * @param email     The email entered by the user.
     * @param password  The password entered by the user.
     * @return      The delivery person associated with the input email address 
     *              and password if they can be found in the delivery person 
     *              manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method signs up a customer user through a command line interface. 
     * It first prompts the user to enter their name. Then, the getCredentials() 
     * method is called to retrieve the customer's email and password. The 
     * method searches for the customer by their email, calling the customer 
     * manager's searchCustomer() method. If the returned customer is null, a 
     * new customer object containing the input information is created, and a 
     * message is displayed informing the user that their account has been 
     * successfully created. The newly created customer object is also returned. 
     * Otherwise, a message is  displayed informing the user that a customer 
     * associated with the email address already exists, and a null value is 
     * returned.
     * 
     * @param cm    The customer manager that stores all of the information
     *              about the customers in the system.
     * @return      The newly created customer object associated with the input 
     *              name, email address, and password if they cannot be found in 
     *              the customer manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method signs up a customer user through a GUI. It first searches for 
     * the customer by their email, calling the customer manager's 
     * searchCustomer() method. If the returned customer is null, a new customer
     * object containing the name, email, and password from the input parameters
     * is created, and a message is displayed informing the user that their 
     * account has been successfully created. The newly created customer object 
     * is also returned. Otherwise, a message is displayed informing the user 
     * that a customer associated with the email address already exists, and a 
     * null value is returned.
     * 
     * @param customerEntry The GUI user entry menu.
     * @param cm        The customer manager that stores all of the information
     *                  about the customers in the system.
     * @param name      The name entered by the user.
     * @param email     The email entered by the user.
     * @param password  The password entered by the user.
     * @return      The newly created customer object associated with the input 
     *              name, email address, and password if they cannot be found in 
     *              the customer manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method creates a new profile for a delivery person user through a 
     * command line interface. It first prompts the user to enter their name. 
     * Then, the getCredentials() method is called to retrieve the employee's 
     * email and password. The method searches for the delivery person by their 
     * email, calling the delivery person manager's searchDeliveryPerson() 
     * method. If the returned delivery person is null, a new delivery person 
     * object containing the input information is created, and a message is 
     * displayed informing the user that their account has been successfully 
     * created. The newly created delivery person object is also returned. 
     * Otherwise, a message is  displayed informing the user that an employee 
     * associated with the email address already exists, and a null value is 
     * returned.
     * 
     * @param dpm   The delivery person manager that stores all of the 
     *              information about the delivery people in the system.
     * @return      The newly created delivery person object associated with the 
     *              input name, email address, and password if they cannot be 
     *              found in the delivery person manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method creates a new profile for a delivery person user through a 
     * GUI. It first searches for the delivery person by their email, calling 
     * the delivery person manager's searchDeliveryPerson() method. If the 
     * returned delivery person is null, a new delivery person object containing
     * the name, email, and password from the input parameters is created, and a 
     * message is displayed informing the user that their account has been 
     * successfully created. The newly created delivery person object is also 
     * returned. Otherwise, a message is displayed informing the user that an 
     * employee associated with the email address already exists, and a null 
     * value is returned.
     * 
     * @param employeeEntry The GUI user entry menu.
     * @param dpm   The delivery person manager that stores all of the 
     *              information about the delivery people in the system.
     * @param name      The name entered by the user.
     * @param email     The email entered by the user.
     * @param password  The password entered by the user.
     * @return      The newly created delivery person object associated with the 
     *              input name, email address, and password if they cannot be 
     *              found in the delivery person manager.
     *              Null otherwise.
     */
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
    
    /**
     * This method logs in a customer user as a guest. It generates a new guest 
     * profile and returns the object associated with that profile.
     * 
     * @param cm    The customer manager that stores all of the information
     *              about the customers in the system.
     * @return      The newly generated guest Customer object.
     */
    public Customer guest(CustomerManager cm){
 
        IDGenerator idgen = new IDGenerator();
            
        int id = idgen.generateId(cm, true);
        Customer guest = new Customer("Guest", id, true);
        guest.setEmail(String.valueOf(id));
        
        cm.addCustomer(guest);
        return guest;
    }
}
