
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores and manages multiple address objects.
 * @author Alexander
 */
public class AddressManager {
    
    /**
     * A Map that stores all of the address objects. The map uses the address
     * IDs as the keys, and the Address objects as the values.
     */
    private Map<Integer, Address> addresses;
    /**
     * An int variable that stores the ID of the primary address.
     */
    private int primaryId;

    /**
     * Class constructor that initializes the addresses Map as a new HashMap.
     */
    public AddressManager(){
        addresses = new HashMap<>();
    }
    
    /**
     * This method adds an address to the addresses Map based on the input
     * address object parameter. It retrieves the address's ID number and
     * searches for the address using the searchAddress() method. If the
     * value returns null, the address does not exist in the Map, so the
     * address object is added to the map. Otherwise, a message is displayed
     * informing the user that the address already exists.
     * 
     * @param address The address to be added to the system.
     */
    public void addAddress(Address address){
        
        int id = address.getAddressID();
        if(this.searchAddress(id) == null){
            addresses.put(id, address);
        }
        else{
            System.out.println("This address already exists.\n");
        }
    }
    
    /**
     * This method searches for the address associated with the input ID 
     * parameter. The address associated with that ID number in the address
     * Map is returned.
     * 
     * @param id The ID number associated with the address to be searched.
     * @return The address associated with the input ID.
     */
    public Address searchAddress(int id){
        return addresses.get(id);
    }
    
    /**
     * This method returns the stored value of the ID associated with the
     * primary address.
     * 
     * @return The ID number associated with the primary address.
     */
    public int getPrimaryAddressID(){return this.primaryId;}
    
    /**
     * This method returns a Boolean value that determines if the address
     * manager has a primary address. If the primary address ID is not 0,
     * there exists a primary address, so the method will return true. Otherwise,
     * no primary address exists, so it will return false.
     * 
     * @return The Boolean value of the expression, getPrimaryAddressID() != 0
     */
    public boolean hasPrimaryAddress(){return getPrimaryAddressID() != 0;}
    
    /**
     * This method removes an address from the addresses Map based on the input
     * address ID number. If the searchAddress() method returns an address
     * object associated with that ID, the address is removed from the
     * addresses Map, and a message is displayed informing the user that the
     * address's information has been deleted successfully. If the address was
     * the primary address, the primary address information is reset by calling
     * the resetPrimaryAddressMethod(). Otherwise, a message is displayed 
     * informing the user that no address with the provided information exists.
     * 
     * @param id The ID number associated with the address to be removed.
     */
    public void deleteAddress(int id){
        
        Address address = searchAddress(id);
        
        if(address != null){
            if(address.isPrimary()){resetPrimaryAddress();}
            addresses.remove(id);
            System.out.println("Address has been deleted successfully.\n");
        }
        else{
            System.out.println("That address does not exist.\n");
        }
    }
    
    /**
     * This method sets the address associated with the input id parameter to
     * the primary address. If the address associated with the input ID is
     * already the primary address, a message is displayed to the user informing
     * them that the address is already set as the primary address. Otherwise,
     * the resetPrimaryAddress() method is called to reset the primary address
     * information, and the new address is set to be primary. The primaryId
     * variable is set to the input id parameter, and a message is displayed
     * to the user informing them that the new address has been set to the 
     * primary address.
     * 
     * @param id The ID number associated with the address to be set as the
     *           primary address.
     */
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
    
    
    /**
     * This method resets the primary address information. It searches for the 
     * primary address in the addresses map. Once the primary address has been
     * found, it is set to no longer be the primary address, and the primaryId
     * is set to 0.
     */
    public void resetPrimaryAddress(){
        for(int id: addresses.keySet()){
            Address address = searchAddress(id);
            if(address.isPrimary()){
                address.setPrimary(false);
                primaryId = 0;
                return;
            }
        }
    }
    
    /**
     * This method returns the size of the addresses Map to provide the number
     * of addresses stored in this AddressManager.
     * 
     * @return The size of the addresses Map.
     */
    public int getNumAddresses(){return addresses.size();}
    
    /**
     * This method returns a Boolean value that determines if this
     * AddressManager stores any addresses. If the addresses Map is empty,
     * it displays a message informing the user that there are no addresses
     * associated with the customer.
     * 
     * @return The Boolean value of the expression !addresses.isEmpty().
     */
    public boolean hasAddresses(){
        if(addresses.isEmpty()){
            System.out.println("There are no addresses associated with this customer.\n");
        }
        return !addresses.isEmpty();
    }
    
    /**
     * This method displays all of the addresses stored within this
     * AddressManager object. It first displays the number of addresses on file.
     * Then, it displays the ID and all of the information associated with each 
     * address.
     */
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
