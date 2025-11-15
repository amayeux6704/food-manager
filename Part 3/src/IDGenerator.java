/**
 *
 * @author Alexander
 */
public class IDGenerator {
    
    public int generateId(CustomerManager cm, boolean isGuest){
        int id;
        
        if(isGuest){
            id = 300 + cm.getNumCustomers();
        }
        else{
            id = 100;
        
            do{id++;}
            while(cm.searchCustomer(id) != null);
        }
        return id;
        
    }
    
    public int generateId(DeliveryPersonManager dpm){
        int baseId = 100; 
        
        int id = baseId;
        
        do{id++;}
        while(dpm.searchDeliveryPerson(id) != null);
        return id;
    }
    
    public int generateId(OrderManager om){
        int baseId = 100; 
        
        int id = baseId;
        
        while(om.searchOrder(id) != null)
            id++;
        
        return id;
    }
    
    public int generateId(AddressManager am){
        
        int id = 0;
        
        do{id++;}
        while(am.searchAddress(id) != null);
        
        return id;
    }
}
