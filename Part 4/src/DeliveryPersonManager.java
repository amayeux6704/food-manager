
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores and manages multiple delivery person objects within the
 * system.
 * @author Alexander
 */
class DeliveryPersonManager {
    /**
     * A Map that stores all of the DeliveryPerson objects. The map uses the 
     * Employee IDs as the keys, and the DeliveryPerson objects as the values.
     */
    private Map<Integer, DeliveryPerson> deliveryPeople;
    
    /**
     * Class constructor that initializes the deliveryPerople Map as a new HashMap.
     */
    public DeliveryPersonManager(){
        deliveryPeople = new HashMap<>();
    }
    
    /**
     * /**
     * This method adds a delivery person to the deliveryPeople Map based on the 
     * input DeliveryPerson object parameter. It retrieves the delivery person's 
     * ID number and searches for the delivery person using the 
     * searchDeliveryPerson() method. If the value returns null, the delivery
     * person does not exist in the Map, so the delivery person object is added 
     * to the map. Otherwise, a message is displayed informing the user that a 
     * delivery person with the input ID already exists.
     *
     * @param deliveryPerson The delivery person to be added to the system.
     */
    public void addDeliveryPerson(DeliveryPerson deliveryPerson){
        
        int id = deliveryPerson.getID();
        
        if(searchDeliveryPerson(id) == null)
            deliveryPeople.put(id, deliveryPerson);
        else
            System.out.println("A Delivery Person with the provided information already exists.");
    }

    /**
     * This method searches for the delivery person associated with the input ID 
     * parameter. The delivery person associated with that ID number in the 
     * deliveryPeople Map is returned.
     * 
     * @param id The ID number associated with the delivery person to be 
     *           searched.
     * @return The delivery person associated with the input ID.
     */
    public DeliveryPerson searchDeliveryPerson(int id){
        return deliveryPeople.get(id);
    }
    /**
     * This method searches for a delivery person associated with the input 
     * email and password parameters. It evaluates each delivery person object 
     * in the deliveryPeople Map and compares its stored email and password with
     * the input email and password. If the email and password match that of a 
     * delivery person that exists within the system, that delivery person is 
     * returned. If no delivery person is associated with the input email and 
     * password, a null value is returned.
     * 
     * @param email     The email address to be searched.
     * @param password  The password to be searched.
     * @return The delivery person object associated with the input email and 
     *         password if they match with the delivery person's stored email 
     *         and password. Null otherwise.
     */
    public DeliveryPerson searchDeliveryPerson(String email, String password){
       
        DeliveryPerson deliveryPerson;
        
        for(int id: deliveryPeople.keySet()){
            deliveryPerson = searchDeliveryPerson(id);
            if(deliveryPerson.getEmail().equals(email) && 
                    deliveryPerson.getPassword().equals(password))
                return deliveryPerson;
        }
        
        return null;
    }
    
    /**
     * This method searches for a delivery person associated with the input 
     * email parameter. It evaluates each delivery person object in the delivery
     * people Map and compares its stored email address with the input email 
     * address. If the email matches that of a delivery person that exists 
     * within the system, that delivery person is returned. If no delivery
     * person is associated with the input email, a null value is returned.
     * 
     * @param email The email address to be searched.
     * @return The delivery person object associated with the input email if it 
     *         matches with the delivery person's stored email and password. 
     *         Null otherwise.
     */
    public DeliveryPerson searchDeliveryPerson(String email){
       
        DeliveryPerson deliveryPerson;
        
        for(int id: deliveryPeople.keySet()){
            deliveryPerson = searchDeliveryPerson(id);
            if(deliveryPerson.getEmail().equals(email))
                return deliveryPerson;
        }
        
        return null;
    }
    
    /**
     * This method removes a delivery person from the deliveryPeople Map based 
     * on the input employee ID number. If the searchDeliveryPerson() method 
     * returns a delivery person object associated with that ID, the delivery
     * person is removed from the deliveryPeople Map, and a message is displayed
     * informing the user that the delivery person's information has been 
     * deleted successfully. Otherwise, a message is displayed informing the 
     * user that no delivery person with the provided information exists.
     * 
     * @param id The ID number associated with the delivery person to be removed.
     */
    public void removeDeliveryPerson(int id){
        if(searchDeliveryPerson(id) != null){
            deliveryPeople.remove(id);
            System.out.println("This Delivery Person's information has been deleted successfully.");
        }
        else
            System.out.println("No Delivery Person with the provided information exists");
    }
}
