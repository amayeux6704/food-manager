/** Manages a dish
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class Dish {

    private String dishName;
    private int dishID;
    private double price;
    private RecipeManager recipe;

    public Dish(int dishID, String dishName, double price){
        this.dishName = dishName;
        this.dishID = dishID;
        this.price = price;
        this.recipe = new RecipeManager();
    }

/**
 * Gets the recipe for a dish
 * @return A recipe for a dish
 */
    public RecipeManager getRecipe(){
        return recipe;
    }

/**
 * Sets the recipe for a dish
 * @param recipe A recipe for a dish
 */
    public void setRecipe(RecipeManager recipe){
        this.recipe = recipe;
    }

/**
 * Gets the id for a dish
 * @return A id for a dish
 */
    public int getDishID(){
        return dishID;
    }

/**
 * Gets the name for a dish
 * @return A name for a dish
 */
    public String getName(){
        return dishName;
    }

/**
 * Gets the price for a dish
 * @return A price for a dish
 */
    public double getPrice(){
        return price;
    }

/**
 * Sets the name for a dish
 * @param dishName A string representing a name for a dish
 */
    public void setName(String dishName){
        this.dishName = dishName;
    }

/**
 * Sets the price for a dish
 * @param price A double representing a price for a dish
 */
    public void setPrice(double price){
        this.price = price;
    }

/** Sets the format for displaying a dish's information
 */
    @Override
    public String toString(){
        return dishName + " (ID: " + dishID + ", Price: $" + price + ")";
    } 

    @Override
    public boolean equals(Object obj){
        if (this == obj){ 
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Dish dish = (Dish) obj;
        return dishID == dish.dishID;
    }

    @Override
    public int hashCode(){
        return dishID;
    }
}
