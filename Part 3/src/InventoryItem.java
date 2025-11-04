public class InventoryItem {

    private String name;
    private int quantity;

    public InventoryItem(String name, int quantity){
        this.name = name;
        this.quantity = 0;
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

    @Overide
    public String toString(){

    }
}
