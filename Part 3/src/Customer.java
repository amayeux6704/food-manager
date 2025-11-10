
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
public class Customer extends Person{
    
    private boolean guest;
    private AddressManager addressManager;
    
    public Customer(String name, int id, Boolean guest){
        super(name, id);
        this.guest = guest;
        addressManager = new AddressManager();
    }
    
    public AddressManager getAddressManager(){return this.addressManager;}
    
    public Boolean isGuest(){return this.guest;}
    
    @Override
    public String toString(){
        String str = "Customer name: " + this.getName() +
                     "\nCustomer ID: " + this.getID() +
                     "\nEmail Address: " + this.getEmail() +
                     "\n";
        return str;
    } 
}
