import java.util.HashSet;
import java.util.Set;

public class SidesManager {

    private Set<String> sides;
    private RecipeManager recipe;

    public SidesManager(){
        this.sides = new HashSet<>();
        this.recipe = new RecipeManager();
    }

    public RecipeManager getRecipe(){
        return recipe;
    }

    public void setRecipe(RecipeManager recipe){
        this.recipe = recipe;
    }

    public Set<String> getSides(){
        return new HashSet<>(sides);
    }

    public void addSide(String side){
        this.sides.add(side.toLowerCase());
    }

    public void removeSide(String side){
        if(sides.contains(side.toLowerCase())){
            this.sides.remove(side.toLowerCase());
            System.out.println(side.toLowerCase() + " has successfully been removed.");
        } else {
            System.out.println("The given side could not be found for removal");
        }
    }

    public void updateSide(String oldSide, String newSide){
        if(sides.contains(oldSide.toLowerCase())){
            this.sides.remove(oldSide.toLowerCase());
            this.sides.add(newSide.toLowerCase());
            System.out.println("The side has been updated.");
        } else {
            System.out.println("The given side could not be found. Update failed.");
        }
    }
}
