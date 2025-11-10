
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Alexander
 */
public class CustomerManager {
    private Map<Integer, Customer> customers;
    
    public CustomerManager(){
        customers = new HashMap<>();
    }
    
    public void addCustomer(Customer customer){
        
        int id = customer.getID();
        
        if(searchCustomer(id) == null)
            customers.put(id, customer);
        else
            System.out.println("A customer with the provided information already exists.");
    }

    public Customer searchCustomer(int id){
        return customers.get(id);
    }
    
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
    
    public Customer searchCustomer(String email){
       
        Customer customer;
        
        for(int id: customers.keySet()){
            customer = searchCustomer(id);
            if(customer.getEmail().equals(email))
                return customer;
        }
        
        return null;
    }
    
    public void removeCustomer(int id){
        if(searchCustomer(id) != null){
            customers.remove(id);
            System.out.println("Customer information has been deleted successfully.");
        }
        else
            System.out.println("No customer with the provided information exists");
    }
}
