/**
 * This class is responsible for setting up an order to be placed within the
 * the system.
 * 
 * @author Alexander
 */
public class OrderPlacer {
    
    /**
     * The customer who is placing the order.
     */
    private Customer customer;
    
    /**
     * The general order manager being used throughout the system.
     */
    private OrderManager gom;
    
    /**
     * The order being placed.
     */
    private Order order;
    
    /**
     * The cost calculation object being used throughout the system.
     */
    private CostCalculation cc;
    
    /**
     * The inventory of ingredients.
     */
    private Inventory inventory;
    
    /**
     * The food menu that stores all of the food items that can be ordered.
     */
    private Menu menu;
    
    /**
     * The OrderInventoryChanger that will change the inventory when a dish or
     * side is added to or removed from the order.
     */
    private OrderInventoryChanger oic;
    
    /**
     * Class constructor that initializes the customer, gom, cc, inventory, and
     * menu instance variables based on the input parameters. It also
     * initializes the oic, passing the inventory object as the argument to its
     * constructor.
     * 
     * @param customer  The customer placing the order.
     * @param gom       The general order manager being used throughout the
     *                  system.
     * @param menu      The menu that stores all of the food items.
     * @param cc        The cost calculation object being used throughout the
     *                  system.
     * @param inventory The inventory of ingredients.
     */
    public OrderPlacer(Customer customer, OrderManager gom, Menu menu, CostCalculation cc,
            Inventory inventory){
        this.customer = customer;
        this.gom = gom;
        this.cc = cc;
        this.inventory = inventory;
        this.menu = menu;
        oic = new OrderInventoryChanger(this.inventory);
    }
    
    /**
     * This method initializes the order. It generates a new ID by creating a 
     * new ID generator, and initializes the order passing the new order ID,
     * menu, and cost calculation objects as arguments to the order's 
     * constructor. The order's fulfillment status is set to false, the customer
     * is assigned to the order.
     * 
     * @param menu The food menu that has all of the items available for order.
     */
    public void initializeOrder(Menu menu){
        IDGenerator idgen = new IDGenerator();
        this.order = new Order(idgen.generateId(gom), menu, cc);
        this.order.setFulfillment(false);
        this.order.setCustomer(customer);
    }
    
    /**
     * This method returns a Boolean value that determines if the order is 
     * empty. If the order contains no dishes and no sides, the order is empty.
     * 
     * @return The Boolean value of the expression:
     *         order.getDishes().isEmpty() && order.getSides().isEmpty()
     */
    public boolean emptyOrder(){
        
        return order.getDishes().isEmpty() && order.getSides().isEmpty();
    }
    
    /**
     * This method adds the dish associated with the input ID parameter
     * for as many times as the num parameter specifies. It also decreases the
     * inventory for the items needed for the specified amount of that dish.
     * 
     * @param id    The ID number associated with the dish to be added to the 
     *              order.
     * @param num   The amount of the same dish to be added to the order.
     */
    
    public void addDish(int id, int num){
        for(int i = 1; i <= num; i++){
            order.addDish(id);
            Dish dish = menu.findDish(id);
            oic.decreaseInventory(dish);
        }
    }
    
    /**
     * This method adds a side to the order for as many times as the num 
     * parameter specifies. It also decreases the inventory for the items needed
     * for the specified amount of that side.
     * 
     * @param side  The side to be added to the order.
     * @param num   The amount of the same side to be added to the order.
     */
    public void addSide(Side side, int num){
        for(int i = 1; i <= num; i++){
            order.addSide(side);
            oic.decreaseInventory(side);
        }
    }
    
    /**
     * This method calculates the total cost of the order by calling the order's
     * calculateTotalCost() method.
     */
    public void calculateCost(){
        order.calculateTotalCost();
    }
    
    /**
     * This method removes the dish associated with the input dishId parameter
     * from the order. It also increases the inventory for the items needed for 
     * the dish.
     * 
     * @param dishId The ID number associated with the dish to be removed from
     *               the order.
     */
    public void removeDish(int dishId){
        order.removeDish(dishId);
        
        Dish dish = menu.findDish(dishId);
        oic.increaseInventory(dish);
    }
    
    /**
     * This method removes a side from the order. It also increases the 
     * inventory for the items needed for the side.
     * 
     * @param side The side to be removed from the order.
     */
    public void removeSide(Side side){
        order.removeSide(side);
        
        oic.increaseInventory(side);
    }
    
    /**
     * This method returns the number of items in the order by calling the 
     * order's getNumDishes() method.
     * 
     * @return the value of order.getNumDishes().
     */
    public int getNumItems(){return order.getNumDishes();}
    
    /**
     * This method prints the order for the user to see on the command line.
     */
    public void showOrder(){System.out.println(order);}
    
    /**
     * This method uses a ReceiptGenerator object to generate a receipt for the
     * order.
     */
    public void showReciept(){
        ReceiptGenerator rg = new ReceiptGenerator();
        rg.showReceipt(order);
    }
    
    /**
     * This method sets that payment method for the order as specified by the
     * payment parameter.
     * 
     * @param payment The string value of the payment method to be set for the
     *                order.
     */
    public void setPayment(String payment){
        order.setPayMethod(payment);
    }
    
    /**'
     * This method sets the address where the order is to be delivered as 
     * specified by the addressId parameter. The addressId is used to retrieve
     * the address from the customer's address method. The returned address
     * object is then set as the address for the order.
     * 
     * @param addressId The ID number associated with the address where the
     *                  order is to be delivered.
     */
    public void setAddress(int addressId){
        
        Address address = customer.getAddressManager().searchAddress(addressId);
        
        order.setAddress(address);
        
    }
    
    /**
     * This method places the completed order. It adds the order to both the
     * customer's OrderManager as well as the general order manager that is used
     * throughout the system. The order is then displayed to the user, and a 
     * message is shown informing the user that their order has been placed and
     * to save their order number for confirmation.
     */
    public void placeOrder(){
        customer.getOrderHistory().addOrder(order);
        gom.addOrder(order);
        
        displayOrder();
        System.out.println("\nYour order has been successfully placed!\n"+
                           "Please make sure to save your order number so the delivery driver\n"+
                           "can confirm your order.\n"+
                           "If you are a guest, please make sure you copy your guest ID number\n"+
                           "before you log out, since you won't be able to log back in to view\n"+
                           "your order.\n");
    }
    
    /**
     * This method displays the order to the command line.
     */
    public void displayOrder(){
        System.out.println(order);
    }
    
}
