import java.util.HashSet;
import java.util.Set;

public class RecipeManager {
    private Set<IngredientManager> ingredients;

    public RecipeManager(){
        this.ingredients = new HashSet<>();
    }

    public IngredientManager findIngredient(String name){
        for (IngredientManager ingredient : ingredients){
            if(ingredient.getName().equalsIgnoreCase(name)){
                return ingredient;
            }
        }
        return null;
    }

    public void addIngredient(String name, int quantity) {
        IngredientManager existingIngredient = findIngredient(name);
        if(existingIngredient != null){
            existingIngredient.setQuantity(existingIngredient.getQuantity() + quantity);
        } else {
            ingredients.add(new IngredientManager(name, quantity));
        }
    }

    public Set<IngredientManager> getIngredients(){
        return new HashSet<>(ingredients);
    }

    public void removeIngredient(String ingredient){
        IngredientManager ingredientForRemoval = findIngredient(ingredient);
        if(ingredientForRemoval != null){
            this.ingredients.remove(ingredientForRemoval);
            System.out.println(ingredientForRemoval + " has been removed");
        } else {
            System.out.println("The given ingredient could not be found for removal.");
        }
    }

    public void updateIngredient(String oldIngredient, String newIngredient, int  quantity){
        IngredientManager old = findIngredient(oldIngredient);
        if(old != null){
            this.ingredients.remove(old);
            this.ingredients.add(new IngredientManager(newIngredient.toLowerCase(), quantity));
            System.out.println("The ingredient has been updated.");
        } else {
            System.out.println("The ingredient could not be found. Update failed.");
        }
    }

    @Override
    public String toString(){
        String ingredientList = "";
        for(IngredientManager ingredient : ingredients){
            ingredientList += "- " + ingredient + "\n";
        }
        return ingredientList;
    }
}
