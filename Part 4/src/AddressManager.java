
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexander
 */
public class AddressManager {
    
    private Map<Integer, Address> addresses;
    private int primaryId;
    
    public AddressManager(){
        addresses = new HashMap<>();
    }
    
    public void addAddress(Address address){
        
        int id = address.getAddressID();
        if(this.searchAddress(id) == null){
            addresses.put(id, address);
        }
        else{
            System.out.println("This address already exists.\n");
        }
    }
    
    public Address searchAddress(int id){
        return addresses.get(id);
    }
    
    public Map<Integer, Address> getAddresses(){
        return this.addresses;
    }
    
    public int getPrimaryAddressID(){return this.primaryId;}
    
    public boolean hasPrimaryAddress(){return getPrimaryAddressID() != 0;}
    
    public void deleteAddress(int id){
        
        if(searchAddress(id) != null){
            
            addresses.remove(id);
            System.out.println("Address has been deleted successfully.\n");
        }
        else{
            System.out.println("That address does not exist.\n");
        }
    }
    
    public void setPrimaryAddress(int id){
        
        Address newPrimary = searchAddress(id);
        
        if(newPrimary.isPrimary()){
            System.out.println("This address is already set as your primary address.\n");
        }
        else{
            resetPrimaryAddress();
            newPrimary.setPrimary(true);
            primaryId = id;
            System.out.println("New address has been set to primary!\n");
        }
    }
    
    public void resetPrimaryAddress(){
        for(int id: addresses.keySet()){
            Address address = searchAddress(id);
            if(address.isPrimary()){address.setPrimary(false);}
        }
    }
    
    public int getNumAddresses(){return addresses.size();}
    
    public boolean hasAddresses(){
        if(addresses.isEmpty()){
            System.out.println("There are no addresses associated with this customer.\n");
        }
        return !addresses.isEmpty();
    }
    
    public void showAddresses(){
        System.out.println("Addresses on file: " + getNumAddresses()+ "\n" +
                           "______________________________________________\n");
        for(int id: addresses.keySet()){
            
            Address address = searchAddress(id);
            address.showAddressInformation();
            
            System.out.println("----------------------------------------------\n");
        }
    }
}
