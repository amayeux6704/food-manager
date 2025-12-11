
/**
 * This class stores and handles the information associated with a generic
 * person in the system.
 * 
 * @author Alexander
 */
public class Person {
    
    /**
     * The ID number to be used to identify the person.
     */
    private int personID;
    
    /**
     * The person's name
     */
    private String name;
    
    /**
     * A phone number manager that stores and manages all of the phone numbers
     * associated with this person.
     */
    private PhoneNumberManager phoneNumberManager;
    
    /**
     * The person's email address associated with their user profile.
     */
    private String emailAddress;
    
    /**
     * The person's password associated with their user profile.
     */
    private String password;
    
    /**
     * An order manager that stores and manages this person's order history.
     */
    private OrderManager orderHistory;
    
    /**
     * Class constructor that initializes the person's name and ID based on the
     * input parameters. It also initializes the phone number manager and order
     * history objects. 
     * 
     * @param name  The person's name.
     * @param id    The ID number associated with the person.
     */
    public Person(String name, int id){
        phoneNumberManager = new PhoneNumberManager();
        orderHistory = new OrderManager();
        this.name = name;
        this.personID = id;
    }
    
    /**
     * This method returns the ID associated with the person.
     * 
     * @return This person's ID number.
     */
    public int getID(){return this.personID;}
    
    /**
     * This method returns this person's name.
     * 
     * @return This person's name.
     */
    public String getName() {return this.name;}
    
    /**
     * This method sets the person's name based on the input parameter.
     * 
     * @param name The name to be assigned to this person. 
     */
    public void setName(String name) {this.name = name;}
    
    /**
     * This method returns the email address associated with this person.
     * 
     * @return The email address associated with this person.
     */
    public String getEmail(){return this.emailAddress;}
    
    /**
     * This method sets this person's email address based on the input parameter.
     * 
     * @param email The email address to be assigned to this person.
     */
    public void setEmail(String email){this.emailAddress = email;}

    /**
     * This method returns this person's password.
     * 
     * @return The password associated with this person.
     */
    public String getPassword() {return this.password;}

    /**
     * This method sets this person's password based on the input parameter.
     * 
     * @param password The password to be assigned to this person.
     */
    public void setPassword(String password) {this.password = password;}
    
    /**
     * This method returns this person's phone number manager so their phone
     * numbers can be accessed and managed.
     * 
     * @return This person's phone number manager.
     */
    public PhoneNumberManager getPNM() {return this.phoneNumberManager;}
    
    /**
     * This method return's this person's order manager so their order history
     * can be accessed and managed.
     * 
     * @return This person's order history.
     */
    public OrderManager getOrderHistory(){return this.orderHistory;}
}
