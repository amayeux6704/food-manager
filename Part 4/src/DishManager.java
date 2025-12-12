/** 
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class DishManager {

    private Set<Dish> dishes;
    private int nextDishID;

    public DishManager(){
        this.dishes = new HashSet<>();
        this.nextDishID = 1;
    }
/**
 * Gets the set of dishes
 * @return The dishes in the set
 */
    public Set<Dish> getDishes(){
        return dishes;
    }

/**
 * Gets the next dish id
 * @return The next dish's id
 */    
    public int getNextDishID(){
        return nextDishID;
    }

/**
 * Adds a recipe for a dish
 * @param dishID A integer for representing a dish's id
 * @param recipe A Recipe for a dish
 */
    public void addDishRecipe(int dishID, RecipeManager recipe){
        Dish dish = findDish(dishID);
        if (dish != null){
            dish.setRecipe(recipe);
            System.out.println("Recipe added to dish: " + dish.getName());
        } else {
            System.out.println("Dish could not be found");
        }
    }

/**
 * Finds a dish using its id
 * @param dishID A integer for representing a dish's id
 * @return The dish information when found or null if not found
 */
    public Dish findDish(int dishID){
        for(Dish dish : dishes) {
            if(dish.getDishID() == dishID){
                return dish;
            }
        }
        return null;
    }

/**
 * Gets the price of a dish
 * @param dishID A integer for representing the dish's id
 * @return The price of a dish if it exists
 */
    public double getDishPrice(int dishID){
        Dish dish = findDish(dishID);
        if(dish != null){
            return dish.getPrice();
        } else {
        System.out.println("Dish could not be found");
        return 0.0;
        }
    }

/**
 * Adds a dish to the set of dishes
 * @param dishName A string representing the name of a dish
 * @param price A double representing the price of a dish
 */
    public void addDish(String dishName, double price){
        boolean exists = false;
        for(Dish dish : dishes){
            if(dish.getName().equalsIgnoreCase(dishName)){
                exists = true;
                break;
            }    
        }
        if(!exists) {
            Dish newDish = new Dish(nextDishID, dishName, price);
            dishes.add(newDish);
            System.out.println("Added: " + newDish + " to the list of available dishes");
            nextDishID++;       
        } else {
            System.out.println("Dish  " + dishName + " Already exists");
        }
    }

/**
 * Removes a dish from the set of dishes
 * @param dishID A integer for representing the id of a dish
 */
    public void removeDish(int dishID){
        Dish dishForRemoval = findDish(dishID);
        if (dishForRemoval != null){
            dishes.remove(dishForRemoval);
            System.out.println("Removed: " + dishForRemoval.getName() + " from the list of available dishes");
        } else {
            System.out.println("Dish does not exist");
        }
    }

/**
 * Updates the name of a dish
 * @param dishID A integer for representing the id of a dish
 * @param newName A string for representing the new name for a dish
 */
    public void updateDishName(int dishID, String newName){
        Dish dish = findDish(dishID);
        if (dish != null){
            dish.setName(newName);
            System.out.println("Dish name has been updated");
        } else {
            System.out.println("Dish does not exist");
        }
    }

/**
 * Updates the price of a dish
 * @param dishID A integer for representing the id of a dish
 * @param newPrice A double for representing the new price for a dish
 */
    public void updateDishPrice(int dishID, double newPrice){
        Dish dish = findDish(dishID);
        if (dish != null){
            dish.setPrice(newPrice);
            System.out.println("Dish price has been updated");
        } else {
            System.out.println("Dish does not exist");
        }
    }
}
