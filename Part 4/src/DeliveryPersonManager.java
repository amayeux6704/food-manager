
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexander
 */
class DeliveryPersonManager {
    private Map<Integer, DeliveryPerson> deliveryPeople;
    
    public DeliveryPersonManager(){
        deliveryPeople = new HashMap<>();
    }
    
    public void addDeliveryPerson(DeliveryPerson deliveryPerson){
        
        int id = deliveryPerson.getID();
        
        if(searchDeliveryPerson(id) == null)
            deliveryPeople.put(id, deliveryPerson);
        else
            System.out.println("A Delivery Person with the provided information already exists.");
    }

    public DeliveryPerson searchDeliveryPerson(int id){
        return deliveryPeople.get(id);
    }
    
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
    
    public DeliveryPerson searchDeliveryPerson(String email){
       
        DeliveryPerson deliveryPerson;
        
        for(int id: deliveryPeople.keySet()){
            deliveryPerson = searchDeliveryPerson(id);
            if(deliveryPerson.getEmail().equals(email))
                return deliveryPerson;
        }
        
        return null;
    }
    
    public void removeDeliveryPerson(int id){
        if(searchDeliveryPerson(id) != null){
            deliveryPeople.remove(id);
            System.out.println("This Delivery Person's information has been deleted successfully.");
        }
        else
            System.out.println("No Delivery Person with the provided information exists");
    }
}
