
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
public class Customer extends Person{
    
    private boolean guest;
    private AddressManager addressManager;
    private Payment payMethods;
    
    public Customer(String name, int id, Boolean guest){
        super(name, id);
        this.guest = guest;
        addressManager = new AddressManager();
        payMethods = new Payment("");
    }
    
    public AddressManager getAddressManager(){return this.addressManager;}
    
    public String getPrimaryPayment(){return payMethods.getCurrentPayMethod();}
    
    public void setPrimaryPayment(String payment){payMethods.setCurrentPayMethod(payment);}
    
    public void addPayMethod(String newMethod){payMethods.addPayMethod(newMethod);}
    
    public void removePayMethod(String methodForRemoval){payMethods.removePayMethod(methodForRemoval);}
    
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
