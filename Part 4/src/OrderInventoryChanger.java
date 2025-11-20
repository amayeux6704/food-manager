
import java.util.Set;

/**
 *
 * @author Alexander
 */
public class OrderInventoryChanger {
    
    private Inventory inventory;
            
    public OrderInventoryChanger(Inventory inventory){
        this.inventory = inventory;
    }
    
    public void decreaseInventory(Dish dish){
        RecipeManager recipe = dish.getRecipe();
        decreaseInventory(recipe);
        
    }
    
    public void decreaseInventory(Side side){
        RecipeManager recipe = side.getRecipe();
        decreaseInventory(recipe);
    }
    
    private void decreaseInventory(RecipeManager recipe){
        Set<IngredientManager> ingredients = recipe.getIngredients();
        
        for(IngredientManager ingredient: ingredients){
            inventory.decreaseInventory(ingredient.getName(), ingredient.getQuantity());
        }
    }
    
    public void increaseInventory(Dish dish){
        RecipeManager recipe = dish.getRecipe();
        increaseInventory(recipe);
    }
    
    public void increaseInventory(Side side){
        RecipeManager recipe = side.getRecipe();
        increaseInventory(recipe);
    }
    
    private void increaseInventory(RecipeManager recipe){
        Set<IngredientManager> ingredients = recipe.getIngredients();
        
        for(IngredientManager ingredient: ingredients){
            inventory.addOrUpdateItem(ingredient.getName(), ingredient.getQuantity());
        }
    }
}
