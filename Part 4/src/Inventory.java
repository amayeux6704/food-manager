/** Manages the inventory
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class Inventory {
    private Set<InventoryItem> inventory;

    public Inventory(){
        this.inventory = new HashSet<>();
    }
    
/**
 * Gets the set of inventory items
 * @return The inventory items in the set
 */
    public Set<InventoryItem> getInventoryItems(){
        return inventory;
    }
    
/**
 * Adds a item to the inventory items
 * @param name A String representing a items name
 * @param quantity A Integer representing a items quantity
 */
    public void addItem(String name, int quantity){
        if(findItem(name) == null){
            inventory.add(new InventoryItem(name, quantity));
        } 
    }
    
/**
 * Adds to update the quantity of a already existing item
 * @param name A string representing the name of an item
 * @param quantity A integer representing the quantity of a item
 */
    public void addOrUpdateItem(String name, int quantity){
        InventoryItem existingItem = findItem(name);
        if(existingItem != null){
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            System.out.println("Updated quantity for " + name);
        } else {
            inventory.add(new InventoryItem(name, quantity));
            System.out.println("Added new item by the name of " + name);
        }
    }

/**
 * Finds a items information by name
 * @param name A string representing a items name
 * @return The items information
 */
    public InventoryItem findItem(String name){
        for(InventoryItem item : inventory) {
            if(item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

/**
 * Decreases the quantity of a item in inventory
 * @param itemName A string representing the name of an item
 * @param quantity A integer representing the quantity of a item
 */
    public void decreaseInventory(String itemName, int quantity){
        InventoryItem item = findItem(itemName);
        if (item != null) {
            int currentQuantity = item.getQuantity();
            if(currentQuantity >= quantity) {
                item.setQuantity(currentQuantity - quantity);
                System.out.println("Inventory quantity updated for " + itemName);
            } else {
                System.out.println("Warning not enough " + itemName + " to fulfill order");
            }
        } else {
            System.out.println("Item by the name of " + itemName + " could not be found");
        }
    }

/** Displays the inventory 
 */
    public void displayInventory(){
        if(inventory.isEmpty()){
            System.out.println("There is nothing in inventory");
        } else {
            for(InventoryItem item : inventory){
                System.out.println(item);
            }
        }
    }
}
