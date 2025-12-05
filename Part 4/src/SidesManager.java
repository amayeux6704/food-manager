/** Manages sides
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class SidesManager {

    private Set<Side> sides;

    public SidesManager(){
        this.sides = new HashSet<>();
    }

/**
 * Adds a recipe to a side
 * @param recipe A recipe for a side
 * @param sideName A string representing a sides name
 */
    public void addSideRecipe(RecipeManager recipe, String sideName){
        Side side = findSide(sideName);
        if (side != null){
            side.setRecipe(recipe);
            System.out.println("Recipe added to side: " + sideName);
        } else {
            System.out.println("Side with name "+ sideName + " could not be found");
        }
    }

/**
 * Finds a side by its name
 * @param name A string representing a sides name
 * @return A side if it exists
 */
    public Side findSide(String name){
        for (Side side : sides){
            if (side.getName().equalsIgnoreCase(name)){
                return side;
            }
        }
        return null;
    }

/**
 * Gets the set of sides
 * @return The set of sides
 */
    public Set<Side> getSides(){
        return new HashSet<>(sides);
    }

/**
 * Adds a side to the set of sides
 * @param side A string representing a side
 */
    public void addSide(String side){
        if (findSide(side) == null){
            this.sides.add(new Side(side));
            System.out.println("Added side: " + side);
        } else {
            System.out.println("Side " + side + " already exists");
        }
    }

/**
 * Removes a side from the set of sides
 * @param side A string representing a side
 */
    public void removeSide(String side){
        Side sideToRemove = findSide(side);
        if(sideToRemove != null){
            this.sides.remove(sideToRemove);
            System.out.println(side + " has successfully been removed");
        } else {
            System.out.println("The given side could not be found for removal");
        }
    }

/**
 * Updates a side
 * @param oldSide A string representing a old side
 * @param newSide A string representing the new side
 */
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
