
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
class Order {
    private int orderID;
    private ArrayList<Dish> dishes;
    private ArrayList<Side> sides;
    private Customer customer;
    private Address address;
    private DeliveryPerson deliveryPerson;
    private Menu menu;
    private String payment;
    private boolean fulfilled;
    private CostCalculation costCalculation;
    private double taxRate;
    
    public Order(int id, Menu menu, CostCalculation costCalculation){
        
        this.dishes = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.orderID = id;
        this.menu = menu;
        taxRate = costCalculation.getTaxRate();
    }
    
    public int getOrderId(){return this.orderID;}
    
    public Customer getCustomer(){return this.customer;}
    
    public Address getAddress() {return this.address;}
    
    public DeliveryPerson getDeliveryPerson(){return this.deliveryPerson;}
    
    public ArrayList<Dish> getDishes(){return this.dishes;}
    
    public ArrayList<Side> getSides(){return this.sides;}
    
    public int getNumDishes(){return dishes.size();}
    
    public int getNumSides(){return sides.size();}
    
    public String getPayMethod(){return this.payment;}
    
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
        costCalculation = new CostCalculation();
        costCalculation.setTaxRate(taxRate);
        
        for(Dish dish: dishes){
            costCalculation.calculateDishSubTotal(dish);
        }
        
        costCalculation.calculateTaxCost();
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
    
    public void displayTaxRate(){
        if(costCalculation == null){
            System.out.println("This order has not yet been calculated.");
        }
        else{
            costCalculation.displayTaxRate();
        }
    }
    
    public void displayTaxCost(){
        if(costCalculation == null){
            System.out.println("This order has not yet been calculated.");
        }
        else{
            System.out.println("Tax cost: " + getTaxCost());
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
        
        str = "<html>Order for: " + customer.getName() + " (" + fulfillment + ")<br>"+
              "Customer #" + customer.getID() + "<br>" +
              "______________________________________________<br>"+
              "Order #" + getOrderId() + "<br>" +
              "______________________________________________<br>"+
              "Dishes:<br>"+
              "----------------------------------------------<br>";
        for(Dish dish: dishes){
            str += dish.getName() + ": " + dish.getPrice()+ "<br>";
        }
        str += "\nSides:<br>"+
               "----------------------------------------------<br>";
        for(Side side: sides){
            str += side.getName() + "<br>";
        }
        str += "______________________________________________<br>"+
               "Tax:   $" + getTaxCost() + "<br>" +
               "Total: $" + getTotalCost() + "<br>" +
               "Paid with: " + getPayMethod() + "<br>"+
               "----------------------------------------------<br>"+
               "Delivery Driver: " + dp + "<br>" +
               "Deliver to:<br>" + 
               address.toString();
        
        return str;
    }
    
}
