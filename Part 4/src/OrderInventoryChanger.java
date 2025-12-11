
import java.util.Set;

/**
 * This class changes the inventory while an order is being placed by the
 * customer.
 * 
 * @author Alexander
 */
public class OrderInventoryChanger {
    
    /**
     * The inventory of ingredients being used throughout the system.
     */
    private Inventory inventory;
            
    /**
     * Class constructor that initializes the inventory based on the input 
     * parameter.
     * 
     * @param inventory The inventory of ingredients being used throughout the
     *                  system.
     */
    public OrderInventoryChanger(Inventory inventory){
        this.inventory = inventory;
    }
    
    /**
     * This method decreases the inventory for the ingredients needed for the
     * input dish. It obtains the recipe for that dish and passes the recipe as
     * an argument to the decreaseInventory() method.
     * 
     * @param dish The dish whose ingredients are to be reduced in the inventory.
     */
    public void decreaseInventory(Dish dish){
        RecipeManager recipe = dish.getRecipe();
        decreaseInventory(recipe);   
    }
    
    /**
     * This method decreases the inventory for the ingredients needed for the
     * input side. It obtains the recipe for that side and passes the recipe as
     * an argument to the decreaseInventory() method.
     * 
     * @param side The side whose ingredients are to be reduced in the inventory.
     */
    public void decreaseInventory(Side side){
        RecipeManager recipe = side.getRecipe();
        decreaseInventory(recipe);
    }
    
    /**
     * This method decreases the inventory for ingredients as specified by a 
     * recipe
     * 
     * @param recipe The recipe whose ingredients are to be reduced in the
     *               inventory.
     */
    private void decreaseInventory(RecipeManager recipe){
        Set<IngredientManager> ingredients = recipe.getIngredients();
        
        for(IngredientManager ingredient: ingredients){
            inventory.decreaseInventory(ingredient.getName(), ingredient.getQuantity());
        }
    }
    
    /**
     * This method increases the inventory for the ingredients needed for the
     * input dish. It obtains the recipe for that dish and passes the recipe as
     * an argument to the increaseInventory() method.
     * 
     * @param dish The dish whose ingredients are to be increased in the 
     *             inventory.
     */
    public void increaseInventory(Dish dish){
        RecipeManager recipe = dish.getRecipe();
        increaseInventory(recipe);
    }
    
    /**
     * This method increases the inventory for the ingredients needed for the
     * input side. It obtains the recipe for that side and passes the recipe as
     * an argument to the increaseInventory() method.
     * 
     * @param side The side whose ingredients are to be increased in the 
     *             inventory.
     */
    public void increaseInventory(Side side){
        RecipeManager recipe = side.getRecipe();
        increaseInventory(recipe);
    }
    
    /**
     * This method increases the inventory for ingredients as specified by a 
     * recipe
     * 
     * @param recipe The recipe whose ingredients are to be increased in the
     *               inventory.
     */
    private void increaseInventory(RecipeManager recipe){
        Set<IngredientManager> ingredients = recipe.getIngredients();
        
        for(IngredientManager ingredient: ingredients){
            inventory.addOrUpdateItem(ingredient.getName(), ingredient.getQuantity());
        }
    }
}
