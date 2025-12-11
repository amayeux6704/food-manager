
import java.util.ArrayList;
/**
 * This class stores and handles all of the information about an order placed
 * by a customer within the system. 
 * @author Alexander
 */
class Order {
    /**
     * The ID number to be associated with the order in the system.
     */
    private int orderID;
    
    /**
     * An ArrayList that stores all of the dishes in the order.
     */
    private ArrayList<Dish> dishes;
    
    /**
     * An ArrayList that stores all of the sides in the order.
     */
    private ArrayList<Side> sides;
    
    /**
     * The customer who placed the order.
     */
    private Customer customer;
    
    /**
     * The address where the order is to be delivered.
     */
    private Address address;
    
    /**
     * The delivery person who has or will deliver the order.
     */
    private DeliveryPerson deliveryPerson;
    
    /**
     * The food menu from where the dishes and sides will be retrieved.
     */
    private Menu menu;
    
    /**
     * The payment method used to pay for the order.
     */
    private String payment;
    
    /**
     * A Boolean variable that determines whether the order has been fulfilled
     * by the delivery person.
     */
    private boolean fulfilled;
    
    /**
     * A CostCalculation object to be used to calculate the total cost of the
     * order.
     */
    private CostCalculation costCalculation;
    
    /**
     * The tax rate for the order.
     */
    private double taxRate;
    
    /**
     * Class constructor that initializes the order ID number as well as the
     * menu items based on the input parameters. It also initializes the dishes 
     * and sides ArrayLists so dishes and sides can be added. It also assigns 
     * the tax rate using the stored tax rate value from the CostCalculation 
     * parameter. The CostCalculation instance variable is not initialized in 
     * this constructor.
     * 
     * @param id                The ID number associated with the order.
     * @param menu              The food menu being used throughout the system.
     * @param costCalculation   The CostCalculation object being used throughout
     *                          the system to retrieve the tax rate.
     *                          
     */
    public Order(int id, Menu menu, CostCalculation costCalculation){
        
        this.dishes = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.orderID = id;
        this.menu = menu;
        taxRate = costCalculation.getTaxRate();
    }
    
    /**
     * This method returns the ID number associated with this order.
     * 
     * @return The ID number associated with this order.
     */
    public int getOrderId(){return this.orderID;}
    
    /**
     * This method returns the Customer who placed this order.
     * 
     * @return The Customer who placed this order.
     */
    
    public Customer getCustomer(){return this.customer;}
    
    /**
     * This method returns the address where this order is to be delivered.
     * 
     * @return The address where this order is to be delivered.
     */
    public Address getAddress() {return this.address;}
    
    /**
     * This method returns the delivery person who has or will deliver the order.
     *
     * @return The delivery person who has or will deliver the order.
     */
    public DeliveryPerson getDeliveryPerson(){return this.deliveryPerson;}
    
    /**
     * This method returns the ArrayList containing all of the dishes in this
     * order.
     *
     * @return The ArrayList containing all of the dishes in this order.
     */
    public ArrayList<Dish> getDishes(){return this.dishes;}
    
    /**
     * This method returns the ArrayList containing all of the sides in this
     * order.
     *
     * @return The ArrayList containing all of the sides in this order.
     */
    public ArrayList<Side> getSides(){return this.sides;}
    
    /**
     * This method returns the size of the dishes ArrayList to provide the 
     * number of dishes in this order
     * 
     * @return The size of the dishes ArrayList.
     */
    public int getNumDishes(){return dishes.size();}
    
    /**
     * This method returns the size of the sides ArrayList to provide the 
     * number of sides in this order
     * 
     * @return The size of the sides ArrayList.
     */
    public int getNumSides(){return sides.size();}
    
    /**
     * This method returns the stored payment method that was used to pay for 
     * this order.
     * 
     * @return The String value of the stored payment method that was used to 
     *         pay for this order.
     */
    public String getPayMethod(){return this.payment;}
    
    /**
     * This method assigns the customer to this order based on the input
     * parameter.
     * 
     * @param customer The customer to be assigned to the order.
     */
    public void setCustomer(Customer customer){this.customer = customer;}
    
    /**
     * This method sets the address where this order is to be delivered based on
     * the input parameter.
     * 
     * @param address The address where the order is to be delivered.
     */
    public void setAddress(Address address){this.address = address;}
    
    /**
     * This method sets the delivery person who will deliver the order based on
     * the input parameter.
     * 
     * @param DP The delivery person who will deliver the order.
     */
    public void setDeliveryPerson(DeliveryPerson DP){this.deliveryPerson = DP;}
    
    /**
     * This method sets the payment method that will be used to pay for the 
     * order based on the input parameter.
     * 
     * @param payMethod The String value of the payment method to be used to
     *                  pay for the order.
     */
    public void setPayMethod(String payMethod){this.payment = payMethod;}
    
    /**
     * This method adds a dish to the dishes ArrayList. Using the dishId 
     * parameter, it searches for the dish in the menu and returns the dish
     * object associated with that ID. It then adds that dish object to the 
     * dishes ArrayList.
     * 
     * @param dishId The ID number of the dish to be added to the dishes 
     *               ArrayList.
     */
    public void addDish(int dishId){
        Dish dish = menu.findDish(dishId);
        
        dishes.add(dish);
    }
    
    /**
     * This method removes a dish from the dishes ArrayList. Using the dishId
     * parameter, it searches for the dish in the menu and returns the dish
     * object associated with that ID. If the dishes ArrayList contains that
     * dish, the dish is removed from the ArrayList and a message is printed
     * informing the user that the dish has been removed successfully. Otherwise,
     * a message is displayed informing the user that this order does not
     * contain that dish.
     * 
     * @param dishId The ID number of the dish to be removed to the dishes 
     *               ArrayList.
     */
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
    
    /**
     * This method adds a side to the sides ArrayList based on the input side
     * parameter.
     * 
     * @param side The side to be added to the sides ArrayList.
     */
    public void addSide(Side side){
        
        sides.add(side);
    }
    
    /**
     * This method removes a side from the sides ArrayList based on the input 
     * side parameter. If the sides ArrayList contains the side, it is removed
     * from the ArrayList and a message is printed informing the user that the
     * side has been removed successfully. Otherwise, a message is displayed
     * informing the user that the order does not contain that side.
     * 
     * @param side The side to be removed from the sides ArrayList.
     */
    public void removeSide(Side side){
       
        if(sides.contains(side)){
        
            sides.remove(side);
            System.out.println("Side has been removed successfully!\n");
        }
        else{
            System.out.println("This order does not contain that side");
        }
    }
    
    /**
     * This method displays all of the dishes within the order. If the dishes
     * ArrayList is empty, a message is printed to the user informing them that
     * no dishes have been added to the order. Otherwise, each dish from the 
     * dishes ArrayList are displayed to the user.
     */
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
    
    /**
     * This method displays all of the sides within the order. If the sides
     * ArrayList is empty, a message is printed to the user informing them that
     * no sides have been added to the order. Otherwise, each side from the 
     * sides ArrayList are displayed to the user.
     */
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
    
    /**
     * This method calculates the total cost of the order. It first initializes
     * the CostCalculation instance variable for this order so it can handle 
     * calculating the cost for this order only. It also sets the tax rate for
     * the order based on the taxRate instance variable. The cost of each dish
     * are then added to the subtotal of the CostCalculation object. After the
     * cost of each dish has been added, the tax cost is then calculated.
     * Finally, the total cost is calculated. 
     * 
     * Note: This method must be called before any cost information can be
     * displayed, as this is where the CostCalculation instance variable is
     * initialized.
     */
    public void calculateTotalCost(){
        costCalculation = new CostCalculation();
        costCalculation.setTaxRate(taxRate);
        
        for(Dish dish: dishes){
            costCalculation.calculateDishSubTotal(dish);
        }
        
        costCalculation.calculateTaxCost();
        costCalculation.calculateTotalCost();
    }
    
    /**
     * This method returns the tax rate. 
     * 
     * @return The tax rate.
     */
    public double getTaxRate(){return this.taxRate;}
    
    /**
     * This method returns the tax cost stored in the CostCalculation object. 
     * 
     * @return The tax cost stored in the CostCalculation object.
     */
    public double getTaxCost(){return this.costCalculation.getTaxCost();}
    
    /**
     * This method returns the total cost of the order stored in the 
     * CostCalculation object.
     * 
     * @return The total cost of the order stored in the CostCalculation object.
     */
    public double getTotalCost(){return this.costCalculation.getTotalCost();}
    
    /**
     * This method displays the total cost of the order stored in the
     * CostCalculation object. If the CostCalulation object is null, a message
     * is displayed informing the user that the order has not yet been 
     * calculated. Otherwise, the total cost is displayed using the
     * CostCalculation object's displayTotalCost() method.
     */
    public void displayTotalCost(){
        if(costCalculation == null){
            System.out.println("This order has not yet been calculated.");
        }
        else{
            costCalculation.displayTotalCost(costCalculation.getTotalCost());
        }
    }
    
    /**
     * This method displays the tax rate of the order stored in the
     * CostCalculation object. If the CostCalulation object is null, a message
     * is displayed informing the user that the order has not yet been 
     * calculated. Otherwise, the tax rate is displayed using the
     * CostCalculation object's displayTaxRate() method.
     */
    public void displayTaxRate(){
        if(costCalculation == null){
            System.out.println("This order has not yet been calculated.");
        }
        else{
            costCalculation.displayTaxRate();
        }
    }
    
    /**
     * This method displays the tax cost of the order stored in the
     * CostCalculation object. If the CostCalulation object is null, a message
     * is displayed informing the user that the order has not yet been 
     * calculated. Otherwise, the tax cost is displayed using the
     * CostCalculation object's displayTaxCost() method.
     */
    public void displayTaxCost(){
        if(costCalculation == null){
            System.out.println("This order has not yet been calculated.");
        }
        else{
            System.out.println("Tax cost: " + getTaxCost());
        }
    }
    
    /**
     * This method sets the Boolean variable that determines the order's 
     * fulfillment status based on the input parameter.
     * 
     * @param fulfilled The Boolean value to be assigned to the order's
     *                  fulfillment status.
     */
    public void setFulfillment(boolean fulfilled) {this.fulfilled = fulfilled;}
    
    /**
     * This method returns the Boolean value that determines the order's
     * fulfillment status.
     * 
     * @return The Boolean value of this order's fulfillment status.
     */
    public boolean isFulfilled(){return this.fulfilled;}
    
    /**
     * This method formats all of the information about the order into a string
     * to be displayed throughout the system. If the order has been fulfilled,
     * the string will display as such. Otherwise, the string will show that 
     * the order is still in progress. If the delivery person has been assigned,
     * the delivery person's name will be displayed on the order. Otherwise, the
     * string will show that a delivery person has not yet been assigned to 
     * this order.
     * 
     * The final formatted string will show the customer's name and ID, the 
     * fulfillment status of the order, the Order ID, all of the dishes and 
     * sides in the order, the cost information, the delivery driver, and the
     * address where the order is to be delivered. Once this has been set, the
     * formatted string will be returned.
     * 
     * @return The formatted string (str) containing all of the information
     *         about the order.
     */
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
