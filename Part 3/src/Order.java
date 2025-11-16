
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
class Order {
    private int orderID;
    private ArrayList<Dish> dishes;
    private ArrayList<Side> sides;
    private String time;
    private String date;
    private Customer customer;
    private Address address;
    private DeliveryPerson deliveryPerson;
    private Menu menu;
    private String payment;
    private boolean fulfilled;
    private CostCalculation costCalculation;
    private float taxRate = 0.04875f;
    
    public Order(int id, Menu menu, CostCalculation costCalculation){
        
        this.dishes = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.orderID = id;
        this.menu = menu;
        this.costCalculation = costCalculation;
    }
    
    public int getOrderId(){return this.orderID;}
    
    public String getTime(){return this.time;}
    
    public String getDate(){return this.date;}
    
    public Customer getCustomer(){return this.customer;}
    
    public Address getAddress() {return this.address;}
    
    public DeliveryPerson getDeliveryPerson(){return this.deliveryPerson;}
    
    public ArrayList<Dish> getDishes(){return this.dishes;}
    
    public ArrayList<Side> getSides(){return this.sides;}
    
    public int getNumDishes(){return dishes.size();}
    
    public int getNumSides(){return sides.size();}
    
    public String getPayMethod(){return this.payment;}
    
    public void setTime(String time){this.time = time;}
    
    public void setDate(String date){this.date = date;}
    
    public void setCustomer(Customer customer){this.customer = customer;}
    
    public void setAddress(Address address){this.address = address;}
    
    public void setDeliveryPerson(DeliveryPerson DP){this.deliveryPerson = DP;}
    
    public void setPayMethod(String payMethod){this.payment = payMethod;}
    
    public void addDish(int dishId){
        Dish dish = menu.findDish(dishId);
        
        dishes.add(dish);
    }
    
    public void removeDish(int dishId){
        Dish dish = menu.findDish(dishId);
        if(dishes.contains(dish)){
        
            dishes.remove(dish);
            System.out.println("Dish has been removed successfully!\n");
        }
        else{
            System.out.println("This order does not contain that dish");
        }
    }
    
    public void addSide(Side side){
        
        sides.add(side);
    }
    
    public void removeSide(Side side){
       
        if(sides.contains(side)){
        
            sides.remove(side);
            System.out.println("Side has been removed successfully!\n");
        }
        else{
            System.out.println("This order does not contain that side");
        }
    }
    
    public void displayDishes(){
        if(dishes.isEmpty()){
            System.out.println("No dishes have been added to this order.");
        }
        else{
            for(Dish dish: dishes){
                System.out.println(dish);
            }
        }
    }
    
    public void displaySides(){
        if(sides.isEmpty()){
            System.out.println("No sides have been added to this order.");
        }
        else{
            for(Side side: sides){
                System.out.println(side);
            }
        }
    }
    
    public void calculateTotalCost(){
        
        for(Dish dish: dishes){
            costCalculation.calculateDishSubTotal(dish);
        }
        
        costCalculation.calculateTaxCost(taxRate);
        costCalculation.calculateTotalCost();
    }
    public double getTaxCost(){return this.costCalculation.getTaxCost();}
    
    public double getTotalCost(){return this.costCalculation.getTotalCost();}
    
    public void displayTotalCost(){
        if(costCalculation == null){
            System.out.println("This order has not yet been calculated.");
        }
        else{
            costCalculation.displayTotalCost(costCalculation.getTotalCost());
        }
    }
    
    public void setFulfillment(boolean fulfilled) {this.fulfilled = fulfilled;}
    
    public boolean isFulfilled(){return this.fulfilled;}
    
    @Override
    public String toString(){
        String str, fulfillment, dp;
        
        if(isFulfilled()){fulfillment = "Fulfilled";}
        else{fulfillment = "In Progress";}
        
        if(getDeliveryPerson() != null){dp = getDeliveryPerson().getName();}
        else{dp = "Not Yet Assigned";}
        
        str = "Order for: " + customer.getName() + " (" + fulfillment + ")\n"+
              "Customer #" + customer.getID() + "\n" +
              "______________________________________________\n"+
              "Order #" + getOrderId() + "\n" +
              "Order Placed on " + getDate() + " " + getTime() + "\n"+
              "______________________________________________\n"+
              "Dishes:\n"+
              "----------------------------------------------\n";
        for(Dish dish: dishes){
            str += dish.getName() + ": " + dish.getPrice()+ "\n";
        }
        str += "\nSides:\n"+
               "----------------------------------------------\n";
        for(Side side: sides){
            str += side.getName() + "\n";
        }
        str += "______________________________________________\n"+
               "Tax:   $" + getTaxCost() + "\n" +
               "Total: $" + getTotalCost() + "\n" +
               "Paid with: " + getPayMethod() + "\n"+
               "----------------------------------------------\n"+
               "Delivery Driver: " + dp + "\n" +
               "Deliver to:\n" + 
               address.toString();
        
        return str;
    }
    
}
