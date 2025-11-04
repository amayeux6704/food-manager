import java.util.ArrayList;

public class Menu {

    private ArrayList<Dish> dishes;
    private int nextDishID;

    public Menu(){
        this.dishes = new ArrayList<>();
        this.nextDishID = 1;
    }

    public Dish findDish(int dishID){
        for (Dish dish : dishes){
            if (dish.getDishID() == dishID){
                return dish;
            }
        }
        return null;
    }

    public double getDishPrice(int dishID){
        Dish dish = findDish(dishID);
        if(dish != null){
            return dish.getPrice();
        }
        return -1;
    }

    public void addDish(String dishName, double price){
        Dish newDish = new Dish(nextDishID, dishName, price);
        dishes.add(newDish);
        nextDishID++;
        System.out.println("Added: " + newDish + " to the list of available dishes!");
    }

    public void removeDish(int dishID){
        for (Dish dish : dishes){
            Dish dishForRemoval = findDish(dishID);
            if (dishForRemoval != null){
                dishes.remove(dishForRemoval);
                System.out.println("Removed: " + dishForRemoval.getName() + " from the list of available dishes!");
            } else {
                System.out.println("Dish does not exist.");
            }
        }
    }

    public void updateDishName(int dishID, String newName){
        Dish dish = findDish(dishID);
        if (dish != null){
            dish.setName(newName);
            System.out.println("Dish name has been updated.");
        } else {
            System.out.println("Dish does not exist.");
        }
    }

    public void updateDishPrice(int dishID, double newPrice){
        Dish dish = findDish(dishID);
        if (dish != null){
            dish.setPrice(newPrice);
            System.out.println("Dish price has been updated.");
        } else {
            System.out.println("Dish does not exist.");
        }
    }
    
    public void menuDisplay(){

    }
}
