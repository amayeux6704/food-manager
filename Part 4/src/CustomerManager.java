
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores and manages multiple customer objects within the system.
 * @author Alexander
 */
public class CustomerManager {
    
    /**
     * A Map that stores all of the Customer objects. The map uses the customer
     * IDs as the keys, and the Customer objects as the values.
     */
    private Map<Integer, Customer> customers;
    
    /**
     * Class constructor that initializes the customers Map as a new HashMap.
     */
    public CustomerManager(){
        customers = new HashMap<>();
    }
    
    /**
     * This method adds a customer to the customers Map based on the input
     * customer object parameter. It retrieves the customer's ID number and
     * searches for the customer using the searchCustomer() method. If the
     * value returns null, the customer does not exist in the Map, so the
     * customer object is added to the map. Otherwise, a message is displayed
     * informing the user that a customer with the input ID already exists.
     * 
     * @param customer The customer to be added to the system.
     */
    public void addCustomer(Customer customer){
        
        int id = customer.getID();
        
        if(searchCustomer(id) == null)
            customers.put(id, customer);
        else
            System.out.println("A customer with the provided information already exists.");
    }
    
    /**
     * This method returns the customers Map.
     * 
     * @return the customers map.
     */
    public Map<Integer, Customer> getCustomers(){
        return this.customers;
    }

    /**
     * This method searches for the customer associated with the input ID 
     * parameter. The customer associated with that ID number in the customers
     * Map is returned.
     * 
     * @param id The ID number associated with the customer to be searched.
     * @return The customer associated with the input ID.
     */
    public Customer searchCustomer(int id){
        return customers.get(id);
    }
    
    /**
     * This method searches for a customer associated with the input email
     * and password parameters. It evaluates each customer object in the
     * customers Map and compares its stored email and password with the input
     * email and password. If the email and password match that of a customer
     * that exists within the system, that customer is returned. If no
     * customer is associated with the input email and password, a null value 
     * is returned.
     * 
     * @param email     The email address to be searched.
     * @param password  The password to be searched.
     * @return The customer object associated with the input email and password
     *         if they match with the customer's stored email and password.
     *         Null otherwise.
     */
    public Customer searchCustomer(String email, String password){
       
        Customer customer;
        
        for(int id: customers.keySet()){
            customer = searchCustomer(id);
            if(customer.getEmail().equals(email) && 
                    customer.getPassword().equals(password))
                return customer;
        }
        
        return null;
    }
    
    /**
     * This method searches for a customer associated with the input email
     * parameter. It evaluates each customer object in the customers Map and 
     * compares its stored email address with the input email address. If the 
     * email matches that of a customer that exists within the system, that 
     * customer is returned. If no customer is associated with the input email, 
     * a null value is returned.
     * 
     * @param email The email address to be searched.
     * @return The customer object associated with the input email if it matches
     *         with the customer's stored email and password. Null otherwise.
     */
    public Customer searchCustomer(String email){
       
        Customer customer;
        
        for(int id: customers.keySet()){
            customer = searchCustomer(id);
            if(customer.getEmail().equals(email))
                return customer;
        }
        
        return null;
    }
    
    /**
     * This method removes a customer from the customers Map based on the input
     * customer ID number. If the searchCustomer() method returns a customer
     * object associated with that ID, the customer is removed from the
     * customers Map, and a message is displayed informing the user that the
     * customer's information has been deleted successfully. Otherwise, a 
     * message is displayed informing the user that no customer with the
     * provided information exists.
     * 
     * @param id The ID number associated with the customer to be removed.
     */
    public void removeCustomer(int id){
        if(searchCustomer(id) != null){
            customers.remove(id);
            System.out.println("This customer's information has been deleted successfully.");
        }
        else
            System.out.println("No customer with the provided information exists");
    }
    
    /**
     * This method returns the size of the customers Map to provide the number
     * of customers stored in this CustomerManager.
     * 
     * @return The size of the customers Map.
     */
    public int getNumCustomers(){return customers.size();}
}
