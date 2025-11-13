
/**
 *
 * @author Alexander
 */
public class DeliveryPerson extends Person{
    private Vehicle deliveryVehicle;
    
    public DeliveryPerson(String name, int id){
        super(name, id);
        deliveryVehicle = null;
    }
    
    public DeliveryPerson(String name, int id, Vehicle vehicle){
        super(name, id);
        deliveryVehicle = vehicle;
    }
    
    public Vehicle getDeliveryVehicle(){return this.deliveryVehicle;}
    
    public void setDeliveryVehicle(Vehicle vehicle){this.deliveryVehicle = vehicle;}
    
    @Override
    public String toString(){
        String str = "Employee name: " + this.getName() +
                     "\nEmployee ID: " + this.getID() +
                     "\nEmail Address: " + this.getEmail() +
                     "\n";
        return str;
    }
}
