
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
    private String payment;
    private boolean fulfilled;
    private CostCalculation costCalculation;
    private float taxRate = 0.04875f;
    
    public Order(int id, Menu menu){
        
        this.contents = new ArrayList<>();
        this.costCalculation = new CostCalculation();
        
        this.orderID = id;
        this.menu = menu;
    }
    
    public int getOrderId(){return this.orderID;}
    
    public String getTime(){return this.time;}
    
    public String getDate(){return this.date;}
    
    public Customer getCustomer(){return this.customer;}
    
    public Address getAddress() {return this.address;}
    
    public DeliveryPerson getDeliveryPerson(){return this.deliveryPerson;}
    
    public ArrayList<Dish> getContents(){return this.contents;}
    
    public int getNumContents(){return contents.size();}
    
    public void setTime(String time){this.time = time;}
    
    public void setDate(String date){this.date = date;}
    
    public void setCustomer(Customer customer){this.customer = customer;}
    
    public void setAddress(Address address){this.address = address;}
    
    public void setDeliveryPerson(DeliveryPerson DP){this.deliveryPerson = DP;}
    
    public void setPayMethod(String payMethod){this.payment = payMethod;}
    
    public void addDish(int dishId){
        Dish dish = menu.findDish(dishId);
        
        contents.add(dish);
        costCalculation.calculateDishSubTotal(dish);
    }
    
    public void removeDish(int dishId){
        Dish dish = menu.findDish(dishId);
        if(contents.contains(dish)){
        
            contents.remove(dish);
        }
        else{
            System.out.println("This order does not contain that dish");
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
    
    public double getTotalCost(){
        
        costCalculation.calculateTaxCost(taxRate);
        costCalculation.calculateTotalCost();
        return this.costCalculation.getTotalCost();
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
              "______________________________________________\n"+
              "Order #" + getOrderId() + "\n" +
              "Order Placed on " + getDate() + " " + getTime() + "\n";
        
        for(Dish dish: contents){
            str += dish.getName() + ": " + dish.getPrice()+ "\n";
        }
        
        str += "Total: " + getTotalCost() + "\n" +
               "Delivery Driver: " + dp + "\n" +
               "Deliver to:\n" + 
               address.toString();
        
        return str;
    }
    
}
