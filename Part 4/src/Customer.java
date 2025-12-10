
/**
 * This class stores and handles the information associated with a customer
 * in the system. It is a subclass of the Person class.
 * 
 * @author Alexander
 */
public class Customer extends Person{
    
    /**
     * A Boolean variable to be used to determine if the customer is a guest.
     */
    private boolean guest;
    /**
     * The address manager that manages all of the customer's addresses.
     */
    private AddressManager addressManager;
    /**
     * A Payment object that manages all of the customer's payment methods.
     */
    private Payment payment;
    
    /**
     * Class constructor that initializes the customer's name, ID, and whether
     * they are a guest based on the input parameters. It passes the name and
     * id values as arguments to the superclass constructor. It then initializes
     * both the address manager and payment objects to be used.
     * 
     * @param name  The name of the customer.
     * @param id    The ID number associated with the customer.
     * @param guest A Boolean variable to determine whether the customer is a
     *              guest.
     */
    public Customer(String name, int id, Boolean guest){
        super(name, id);
        this.guest = guest;
        addressManager = new AddressManager();
        payment = new Payment("");
    }
    
    /**
     * This method returns this customer's address manager.
     * 
     * @return This customer's addressManager.
     */
    public AddressManager getAddressManager(){return this.addressManager;}
    
    /**
     * This method returns this customer's payment information.
     * 
     * @return This customer's payment object.
     */
    public Payment getPayment(){return this.payment;}
    
    /**
     * This method returns the Boolean value that determines whether the
     * customer is a guest.
     * 
     * @return The Boolean value that determines whether the customer is a guest.
     */
    public Boolean isGuest(){return this.guest;}
    
    /**
     * This method formats the customer's information into a string to be 
     * displayed within the system. It formats the customer's stored name, ID, 
     * and email address into one string, and returns that string to be used to 
     * display the information.
     * 
     * @return The formatted string (str) containing the customer's information.
     */
    @Override
    public String toString(){
        String str = "<html>Customer name: " + this.getName() +
                     "<br>Customer ID: " + this.getID() +
                     "<br>Email Address: " + this.getEmail() +
                     "<br>";
        return str;
    } 
}
