/**
 *
 * @author Alexander
 */
public class OrderPlacer {
    
    private Customer customer;
    private OrderManager gom;
    private Order order;
    private CostCalculation cc;
    private Inventory inventory;
    private Menu menu;
    private OrderInventoryChanger oic;
    
    public OrderPlacer(Customer customer, OrderManager gom, Menu menu, CostCalculation cc,
            Inventory inventory){
        this.customer = customer;
        this.gom = gom;
        this.cc = cc;
        this.inventory = inventory;
        this.menu = menu;
        oic = new OrderInventoryChanger(this.inventory);
    }
    
    public void initializeOrder(Menu menu){
        IDGenerator idgen = new IDGenerator();
        this.order = new Order(idgen.generateId(gom), menu, cc);
        this.order.setFulfillment(false);
        this.order.setCustomer(customer);
    }
    
    public void addDish(int id, int num){
        for(int i = 1; i <= num; i++){
            order.addDish(id);
        }
        Dish dish = menu.findDish(id);
        oic.decreaseInventory(dish);
    }
    
    public void addSide(Side side, int num){
        for(int i = 1; i <= num; i++){
            order.addSide(side);
        }
        oic.decreaseInventory(side);
    }
    
    public void calculateCost(){
        order.calculateTotalCost();
    }
    
    public void removeDish(int dishId){
        order.removeDish(dishId);
        
        Dish dish = menu.findDish(dishId);
        oic.increaseInventory(dish);
    }
    
    public void removeSide(Side side){
        order.removeSide(side);
        
        oic.increaseInventory(side);
    }
    
    public int getNumItems(){return order.getNumDishes();}
    
    public void showOrder(){System.out.println(order);}
    
    public void showReciept(){
        ReceiptGenerator rg = new ReceiptGenerator();
        rg.showReceipt(order);
    }
    
    public void setPayment(String payment){
        order.setPayMethod(payment);
    }
    
    public void setAddress(int addressId){
        
        Address address = customer.getAddressManager().searchAddress(addressId);
        
        order.setAddress(address);
        
    }
    
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
    
    public void displayOrder(){
        System.out.println(order);
    }
    
}
