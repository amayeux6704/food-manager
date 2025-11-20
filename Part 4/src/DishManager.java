import java.util.HashSet;
import java.util.Set;

public class DishManager {

    private Set<Dish> dishes;
    private int nextDishID;

    public DishManager(){
        this.dishes = new HashSet<>();
        this.nextDishID = 1;
    }

    public Set<Dish> getDishes(){
        return dishes;
    }

    public void addDishRecipe(int dishID, RecipeManager recipe){
        Dish dish = findDish(dishID);
        if (dish != null){
            dish.setRecipe(recipe);
            System.out.println("Recipe added to dish: " + dish.getName());
        } else {
            System.out.println("Dish could not be found");
        }
    }

    public Dish findDish(int dishID){
        for(Dish dish : dishes) {
            if(dish.getDishID() == dishID){
                return dish;
            }
        }
        return null;
    }

    public double getDishPrice(int dishID){
        Dish dish = findDish(dishID);
        if(dish != null){
            return dish.getPrice();
        } else {
        System.out.println("Dish could not be found");
        return 0.0;
        }
    }

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

    public void removeDish(int dishID){
        Dish dishForRemoval = findDish(dishID);
        if (dishForRemoval != null){
            dishes.remove(dishForRemoval);
            System.out.println("Removed: " + dishForRemoval.getName() + " from the list of available dishes");
        } else {
            System.out.println("Dish does not exist");
        }
    }

    public void updateDishName(int dishID, String newName){
        Dish dish = findDish(dishID);
        if (dish != null){
            dish.setName(newName);
            System.out.println("Dish name has been updated");
        } else {
            System.out.println("Dish does not exist");
        }
    }

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
