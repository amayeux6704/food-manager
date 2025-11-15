import java.util.HashSet;
import java.util.Set;

public class SidesManager {

    private Set<Side> sides;

    public SidesManager(){
        this.sides = new HashSet<>();
    }

    public void addSideRecipe(RecipeManager recipe, String sideName){
        Side side = findSide(sideName);
        if (side != null){
            side.setRecipe(recipe);
            System.out.println("Recipe added to side: " + sideName);
        } else {
            System.out.println("Side with name "+ sideName + " could not be found");
        }
    }

    public Side findSide(String name){
        for (Side side : sides){
            if (side.getName().equalsIgnoreCase(name)){
                return side;
            }
        }
        return null;
    }

    public Set<Side> getSides(){
        return new HashSet<>(sides);
    }

    public void addSide(String side){
        if (findSide(side) == null){
            this.sides.add(new Side(side));
            System.out.println("Added side: " + side);
        } else {
            System.out.println("Side " + side + " already exists");
        }
    }

    public void removeSide(String side){
        Side sideToRemove = findSide(side);
        if(sideToRemove != null){
            this.sides.remove(sideToRemove);
            System.out.println(side + " has successfully been removed");
        } else {
            System.out.println("The given side could not be found for removal");
        }
    }

    public void updateSide(String oldSide, String newSide){
        Side sideToUpdate = findSide(oldSide);
        if(sideToUpdate != null){
            sideToUpdate.setName(newSide);
            System.out.println("The side has been updated");
        } else {
            System.out.println("The given side could not be found. Update failed");
        }
    }
}
