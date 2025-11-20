public class IngredientManager {
    private String name;
    private int quantity;

    public IngredientManager(String name, int quantity){
        this.name = name.toLowerCase();
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return quantity + " " + name;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override 
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        IngredientManager other = (IngredientManager) obj;
        return name.equals(other.name);
    }
}
