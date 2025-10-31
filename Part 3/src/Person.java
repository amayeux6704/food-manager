
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class Person {
    
    private int personID;
    private String name;
    private ArrayList<String> phoneNumbers;
    private ArrayList<String> emailAddresses;
    private ArrayList<Order> orderHistory;
    
    public Person(String name, int id){
        phoneNumbers = new ArrayList<>();
        emailAddresses = new ArrayList<>();
        orderHistory = new ArrayList<>();
        
        this.name = name;
        this.personID = id;
    }
    
    public int getID(){return this.personID;}
    
    public String getName() {return this.name;}
    
    public void setName(String name) {this.name = name;}
    
    public void addPhone(String phoneNumber){
        if(phoneNumbers.contains(phoneNumber)){
            System.out.println("The phone number you entered already exists");
        }
        else{
            phoneNumbers.add(phoneNumber);
            System.out.println("Phone number has been added successfully!");
        }
    }
    
    public void addEmail(String email){
        if(emailAddresses.contains(email)){
            System.out.println("The email address you entered already exists");
        }
        else{
            emailAddresses.add(email);
            System.out.println("Email address has been added successfully!");
        }
    }
    
    public void addOrder(Order order){
        orderHistory.add(order);
    }
    
    public void removePhone(String phoneNumber){
        
        if(phoneNumbers.isEmpty()){
            System.out.println("No phone numbers exist for this customer.");
        }
        else if(!phoneNumbers.contains(phoneNumber)){
            System.out.println("The phone number you entered does not exist");
        }
        else{
            phoneNumbers.remove(phoneNumber);
            System.out.println("Phone number has been removed successfully!");
        }
    }
    
    public void removeEmail(String email){
        if(emailAddresses.isEmpty()){
            System.out.println("No phone numbers exist for this customer.");
        }
        else if(!emailAddresses.contains(email)){
            System.out.println("The email address you entered does not exist");
        }
        else{
            emailAddresses.remove(email);
            System.out.println("Email address has been removed successfully!");
        }
    }
    
    public void removeOrder(Order order){
        orderHistory.remove(order);
    }
    
    public void updatePhone(String phoneNumber){
        if(phoneNumbers.isEmpty()){
            System.out.println("No phone numbers exist for this customer.");
        }
        else if(!phoneNumbers.contains(phoneNumber)){
            System.out.println("The phone number to update does not exist");
        }
        else{
            int phoneIndex = phoneNumbers.indexOf(phoneNumber);
            phoneNumbers.set(phoneIndex, phoneNumber);
            System.out.println("Phone number has been updated successfully!");
        }
    }
    
    public void updateEmail(String email){
        if(phoneNumbers.isEmpty()){
            System.out.println("No phone numbers exist for this customer.");
        }
        else if(!emailAddresses.contains(email)){
            System.out.println("The email address to update does not exist");
        }
        else{
            int emailIndex = emailAddresses.indexOf(email);
            emailAddresses.set(emailIndex, email);
            System.out.println("Email address has been updated successfully!");
        }
    }
}
