/** Manages the menu 
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class Menu {

    private DishManager dishManager;
    private SidesManager sidesManager;

    public Menu(){
        this.dishManager = new DishManager();
        this.sidesManager = new SidesManager();
    }

/**
 * Adds a dish to the set of dishes
 * @param name A string representing the name of a dish
 * @param price A double representing the price of a dish
 */
    public void addDish(String name, double price){
        dishManager.addDish(name, price);
    }

/**
 * Adds a dish recipe to the dish
 * @param dishID A integer representing the id of a dish
 * @param recipe A recipe of a dish
 */
    public void addDishRecipe(int dishID, RecipeManager recipe){
        dishManager.addDishRecipe(dishID, recipe);
    }

/**
 * Removes a dish from the set of dishes
 * @param dishID A integer representing the id of a dish
 */
    public void removeDish(int dishID){
        dishManager.removeDish(dishID);
    }

/**
 * Updates a dish's name
 * @param dishId A integer representing the id of a dish
 * @param newName A string representing the new name for a dish
 */
    public void updateDishName(int dishId, String newName){
        dishManager.updateDishName(dishId, newName);
    }

/**
 * Updates the price of a dish
 * @param dishID A integer representing the id of a dish
 * @param newPrice A double representing the new price for a dish
 */
    public void updateDishPrice(int dishID, double newPrice){
        dishManager.updateDishPrice(dishID, newPrice);
    }

/**
 * Finds a dish by it's id
 * @param dishID A integer representing the id of a dish
 * @return The dish found by it's id
 */
    public Dish findDish(int dishID){
        return dishManager.findDish(dishID);
    }

/**
 * Gets the price for a dish by id
 * @param dishID A integer representing the id of a dish
 * @return The price of a dish found by id
 */
    public double getDishPrice(int dishID){
        return dishManager.getDishPrice(dishID);
    }

/**
 * Gets the set of sides
 * @return The set of sides
 */
    public Set<Side> getSides(){
        return sidesManager.getSides();
    }

/**
 * Gets the manager for dishes
 * @return The manager for dishes
 */
    public DishManager getDishManager(){
        return dishManager;
    }
    
/**
 * Gets the manager for sides
 * @return The manager for sides
 */
    public SidesManager getSidesManager(){
        return sidesManager;
    }

/**
 * Adds a side to the set of sides
 * @param side A string representing the side
 */
    public void addSide(String side){
        sidesManager.addSide(side);
    }

/**
 * Adds a recipe to a side
 * @param recipe A recipe for a side
 * @param side A string representing the side
 */
    public void addSideRecipe(RecipeManager recipe, String side){
        sidesManager.addSideRecipe(recipe, side);
    }

/**
 * Removes a side from the sides
 * @param side A string representing a side
 */
    public void removeSide(String side){
        sidesManager.removeSide(side);
    }

/**
 * Updates a side
 * @param oldSide A string representing the old side
 * @param newSide A string representing the new side
 */
    public void updateSide(String oldSide, String newSide){
        sidesManager.updateSide(oldSide, newSide);
    }

/** Displays the menu for both the dishes and sides
 */
    public void menuDisplay(){
        DishDisplay();
        SideDisplay();
    }

/** Displays the menu for dishes
 */
    public void DishDisplay(){
        if(dishManager.getDishes().isEmpty()){
            System.out.println("The menu is empty");
        } else {
            System.out.println("-- Dishes --");
            for(Dish dish : dishManager.getDishes()){
                System.out.println(dish);
                if(!dish.getRecipe().getIngredients().isEmpty()){
                    System.out.println(dish.getRecipe());
                }
            }
        }
    }

/** Displays the menu for sides
 */
    public void SideDisplay(){
        System.out.println("-- Sides --");
        if(sidesManager.getSides().isEmpty()){
            System.out.println("The sides menu is empty");
        } 
        for(Side side : sidesManager.getSides()){
            System.out.println(side.getName());
            if(!side.getRecipe().getIngredients().isEmpty()){
                    System.out.println(side.getRecipe());
            }
        }
    }
}
