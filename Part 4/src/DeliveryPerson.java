
/**
 * This class stores and handles the information associated with a Delivery
 * Person Employee in the system. It is a subclass of the Person class.
 * 
 * @author Alexander
 */
public class DeliveryPerson extends Person{
    /**
     * A Vehicle object that stores and handles the information about the
     * delivery person's delivery vehicle.
     */
    private Vehicle deliveryVehicle;
    
    /**
     * Class constructor that initializes the delivery person's name and ID
     * based on the input parameters. It passes the name and id values as 
     * arguments to the superclass constructor. It also initializes the
     * delivery vehicle to a null value since there is no parameter for a
     * vehicle object.
     * 
     * @param name  The name of the delivery person.
     * @param id    The id number associated with the delivery person.
     */
    public DeliveryPerson(String name, int id){
        super(name, id);
        deliveryVehicle = null;
    }
    
    /**
     * Class constructor that initializes the delivery person's name, ID, and
     * delivery vehicle based on the input parameters. It passes the name and 
     * id values as arguments to the superclass constructor.
     * 
     * @param name    The name of the delivery person.
     * @param id      The id number associated with the delivery person.
     * @param vehicle The delivery vehicle to be assigned to this delivery 
     *                person.
     */
    public DeliveryPerson(String name, int id, Vehicle vehicle){
        super(name, id);
        deliveryVehicle = vehicle;
    }
    
    /**
     * This method return's the delivery vehicle object associated with this
     * delivery person.
     * 
     * @return The delivery vehicle object associated with this delivery person.
     */
    public Vehicle getDeliveryVehicle(){return this.deliveryVehicle;}
    
    /**
     * This method sets the delivery person's delivery vehicle based on the
     * input parameter.
     * 
     * @param vehicle The delivery vehicle to be assigned to this delivery 
     *                person.
     */
    public void setDeliveryVehicle(Vehicle vehicle){this.deliveryVehicle = vehicle;}
    
    /**
     * This method formats the delivery person's information into a string to be 
     * displayed within the system. It formats the delivery person's stored 
     * name, ID, and email address into one string, and returns that string to 
     * be used to display the information.
     * 
     * @return The formatted string (str) containing the delivery person's 
     *         information.
     */
    @Override
    public String toString(){
        String str = "<html>Employee name: " + this.getName() +
                     "<br>Employee ID: " + this.getID() +
                     "<br>Email Address: " + this.getEmail() +
                     "<br>";
        return str;
    }
}
