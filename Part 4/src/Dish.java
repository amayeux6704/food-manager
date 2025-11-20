import java.util.HashSet;
import java.util.Set;

public class Dish {

    private String dishName;
    private int dishID;
    private double price;
    private RecipeManager recipe;

    public Dish(int dishID, String dishName, double price){
        this.dishName = dishName;
        this.dishID = dishID;
        this.price = price;
        this.recipe = new RecipeManager();
    }

    public RecipeManager getRecipe(){
        return recipe;
    }

    public void setRecipe(RecipeManager recipe){
        this.recipe = recipe;
    }

    public int getDishID(){
        return dishID;
    }

    public String getName(){
        return dishName;
    }

    public double getPrice(){
        return price;
    }

    public void setName(String dishName){
        this.dishName = dishName;
    }

    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return dishName + " (ID: " + dishID + ", Price: $" + price + ")";
    } 
    @Override
    public boolean equals(Object obj){
        if (this == obj){ 
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Dish dish = (Dish) obj;
        return dishID == dish.dishID;
    }
    @Override
    public int hashCode(){
        return dishID;
    }
}
