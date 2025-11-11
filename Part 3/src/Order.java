
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
class Order {
    private int orderID;
    private ArrayList<Dish> contents;
    private String time;
    private String date;
    private Customer customer;
    private Address address;
    private DeliveryPerson deliveryPerson;
    private Menu menu;
    private Payment payment;
    private double totalCost;
    
    public Order(int id, Menu menu){
        
        this.contents = new ArrayList<>();
        
        this.orderID = id;
        this.menu = menu;
        this.totalCost = 0;
    }
    
    public int getOrderId(){return this.orderID;}
    
    public String getTime(){return this.time;}
    
    public String getDate(){return this.date;}
    
    public Customer getCustomer(){return this.customer;}
    
    public Address getAddress() {return this.address;}
    
    public DeliveryPerson getDeliveryPerson(){return this.deliveryPerson;}
    
    public void setTime(String time){this.time = time;}
    
    public void setDate(String date){this.date = date;}
    
    public void setCustomer(Customer customer){this.customer = customer;}
    
    public void setAddress(Address address){this.address = address;}
    
    public void setDeliveryPerson(DeliveryPerson DP){this.deliveryPerson = DP;}
    
    public void addDish(int dishId){
        Dish dish = menu.findDish(dishId);
        if(dish != null){
            double dishCost = menu.getDishPrice(dishId);
        
            contents.add(dish);
            this.addToTotalCost(dishCost);
        }
        else{
            System.out.println("That dish does not exist.");
        }
    }
    
    public void removeDish(int dishId){
        Dish dish = menu.findDish(dishId);
        if(dish != null){
            if(contents.contains(dish)){
                double dishCost = menu.getDishPrice(dishId);
        
                contents.remove(dish);
                this.subtractFromTotalCost(dishCost);
            }
            else{
                System.out.println("This order does not contain that dish");
            }
        }
        else{
            System.out.println("That dish does not exist.");
        }
    }
    
    public void displayContents(){
        if(contents.isEmpty()){
            System.out.println("Nothing has been added to this order.");
        }
        else{
            for(Dish dish: contents){
                System.out.println(dish);
            }
        }
    }
    
    public void addToTotalCost(double dishCost){
        this.totalCost += dishCost;
    }
    
    public void subtractFromTotalCost(double dishCost){
        this.totalCost -= dishCost;
    }
    
    public double getTotalCost(){
        return this.totalCost;
    }
    
}
