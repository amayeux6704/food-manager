/** Manages ingredients traits
 * @author Brendan Casey
*/
public class IngredientManager {
    private String name;
    private int quantity;

    public IngredientManager(String name, int quantity){
        this.name = name.toLowerCase();
        this.quantity = quantity;
    }

/**
 * Gets the name for an ingredient
 * @return A name for a ingredient
 */
    public String getName(){
        return name;
    }

/**
 * Gets the quantity for an ingredient
 * @return The quantity of an ingredient
 */
    public int getQuantity(){
        return quantity;
    }

/**
 * Sets the quantity for an ingredient
 * @param quantity A integer representing the quantity of an ingredient
 */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

/** Sets the format for showing the quantity of an ingredient
 */
    @Override
    public String toString(){
        return quantity + " " + name;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override 
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        IngredientManager other = (IngredientManager) obj;
        return name.equals(other.name);
    }
}
