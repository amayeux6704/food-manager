
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
public class Customer extends Person{
    private ArrayList<Address> addresses;
    
    public Customer(String name, int id){
        super(name, id);
        
        addresses = new ArrayList<>();
    }
    
    public Address getAddress(int id){
        return null;
    }
    
    public void removeAddress(int id){
        
    }
    
    public void addAddress(Address address){
        
    }
    
    public void updateAddress(int id){
        
    }
}
