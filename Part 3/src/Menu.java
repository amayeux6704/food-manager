import java.util.HashSet;
import java.util.Set;

public class Menu {

    private DishManager dishManager;
    private SidesManager sidesManager;

    public Menu(){
        this.dishManager = new DishManager();
        this.sidesManager = new SidesManager();
    }

    public void addDish(String name, double price){
        dishManager.addDish(name, price);
    }

    public void addDishRecipe(int dishID, RecipeManager recipe){
        dishManager.addDishRecipe(dishID, recipe);
    }

    public void removeDish(int dishID){
        dishManager.removeDish(dishID);
    }

    public void updateDishName(int dishId, String newName){
        dishManager.updateDishName(dishId, newName);
    }

    public void updateDishPrice(int dishID, double newPrice){
        dishManager.updateDishPrice(dishID, newPrice);
    }

    public Dish findDish(int dishID){
        return dishManager.findDish(dishID);
    }

    public double getDishPrice(int dishID){
        return dishManager.getDishPrice(dishID);
    }

    public Set<Side> getSides(){
        return sidesManager.getSides();
    }

    public void addSide(String side){
        sidesManager.addSide(side);
    }

    public void addSideRecipe(RecipeManager recipe, String side){
        sidesManager.addSideRecipe(recipe, side);
    }

    public void removeSide(String side){
        sidesManager.removeSide(side);
    }

    public void updateSide(String oldSide, String newSide){
        sidesManager.updateSide(oldSide, newSide);
    }

    public void menuDisplay(){
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
