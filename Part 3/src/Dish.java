public class Dish {

    private String dishName;
    private int dishID;
    private double price;

    public Dish(int dishID, String dishName, double price){
        this.dishName = dishName;
        this.dishID = dishID;
        this.price = price;
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

    @Overide
    public String toString(){

    }
}
