/** Manages the items
 * @author Brendan Casey
*/
public class InventoryItem {

    private String name;
    private int quantity;

    public InventoryItem(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

/** Gets the name of an item
 * @return A items name
 */
    public String getName(){
        return name;
    }

/**
 * Gets the quantity of an item
 * @return A items quantity
 */
    public int getQuantity(){
        return quantity;
    }

/**
 * Sets the quantity of an item
 * @param quantity A integer that represents the quantity of an item
 */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

/** Sets the format for displaying a items quantity
 */
    @Override
    public String toString(){
        return name + " ( Quantity: " + quantity + ")";
    }
}
