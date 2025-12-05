/** Manages a side
 * @author Brendan Casey
*/
public class Side {
    private String name;
    private RecipeManager recipe;

    public Side(String name){
        this.name = name.toLowerCase();
        this.recipe = new RecipeManager();
    }

/**
 * Gets the name of a side
 * @return A side's name
 */
    public String getName(){
        return name;
    }

/**
 * Sets the name for a side
 * @param name A string representing a sides name
 */
    public void setName(String name){
        this.name = name.toLowerCase();
    }

/**
 * Gets the recipe for a side
 * @return The side's recipe
 */
    public RecipeManager getRecipe(){
        return recipe;
    }

/**
 * Sets the recipe for a side
 * @param recipe The recipe for a side
 */
    public void setRecipe(RecipeManager recipe){
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){ 
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Side side = (Side) obj;
        return name.equals(side.name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
