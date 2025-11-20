import java.util.HashSet;
import java.util.Set;

public class Inventory {
    private Set<InventoryItem> inventory;

    public Inventory(){
        this.inventory = new HashSet<>();
    }

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

    public InventoryItem findItem(String name){
        for(InventoryItem item : inventory) {
            if(item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

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
