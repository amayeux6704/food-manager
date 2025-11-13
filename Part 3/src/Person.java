
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class Person {
    
    private int personID;
    private String name;
    private PhoneNumberManager phoneNumberManager;
    private String emailAddress;
    private String password;
    private OrderManager orderHistory;
    
    public Person(String name, int id){
        phoneNumberManager = new PhoneNumberManager();
        orderHistory = new OrderManager(this);
        this.name = name;
        this.personID = id;
    }
    
    public int getID(){return this.personID;}
    
    public String getName() {return this.name;}
    
    public void setName(String name) {this.name = name;}
        
    public String getEmail(){return this.emailAddress;}
    
    public void setEmail(String email){this.emailAddress = email;}

    public String getPassword() {return this.password;}

    public void setPassword(String password) {this.password = password;}
    
    public PhoneNumberManager getPNM() {return this.phoneNumberManager;}
    
    public OrderManager getOrderHistory(){return this.orderHistory;}
}
