
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
public class Customer extends Person{
    
    private boolean guest;
    private AddressManager addressManager;
    private Payment payment;
    
    public Customer(String name, int id, Boolean guest){
        super(name, id);
        this.guest = guest;
        addressManager = new AddressManager();
        payment = new Payment("");
    }
    
    public AddressManager getAddressManager(){return this.addressManager;}
    
    public Payment getPayment(){return this.payment;}
    
    public Boolean isGuest(){return this.guest;}
    
    @Override
    public String toString(){
        String str = "<html>Customer name: " + this.getName() +
                     "<br>Customer ID: " + this.getID() +
                     "<br>Email Address: " + this.getEmail() +
                     "<br>";
        return str;
    } 
}
