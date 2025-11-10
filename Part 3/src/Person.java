
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
    private ArrayList<Order> orderHistory;
    
    public Person(String name, int id){
        phoneNumberManager = new PhoneNumberManager();
        orderHistory = new ArrayList<>();
        
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
    
    
    public void addOrder(Order order){
        orderHistory.add(order);
    }
    
    public void removeOrder(Order order){
        orderHistory.remove(order);
    }
    
    public void showOrderHistory(){
        if(orderHistory.isEmpty()){System.out.println("You have not placed any orders yet!");}
        else
        {
            for(Order order: orderHistory){
                System.out.println(order);
            }
        }
    }
}
