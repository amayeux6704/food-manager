/**
 *
 * @author Alexander
 */
public class OrderPlacer {
    
    private Customer customer;
    private OrderManager gom;
    private Order order;
    
    public OrderPlacer(Customer customer, OrderManager gom, Menu menu){
        this.customer = customer;
        this.gom = gom;
    }
    
    public void initializeOrder(Menu menu){
        IDGenerator idgen = new IDGenerator();
        this.order = new Order(idgen.generateId(gom), menu);
        this.order.setFulfillment(false);
        this.order.setCustomer(customer);
    }
    
    public void addItem(int dishId, int num){
        for(int i = 1; i <= num; i++){
            order.addDish(dishId);
        }
    }
    
    public void removeItem(int dishId){order.removeDish(dishId);}
    
    public int getNumItems(){return order.getNumContents();}
    
    public void showOrder(){System.out.println(order);}
    
    public void showReciept(){
        ReceiptGenerator rg = new ReceiptGenerator();
        rg.showReceipt(order);
    }
    
    
    public void setPayment(){
        String payment = customer.getPrimaryPayment();
        order.setPayMethod(payment);
    }
    
    public void setAddress(int addressId){
        
        Address address = customer.getAddressManager().searchAddress(addressId);
        
        order.setAddress(address);
        
    }
    
    public void placeOrder(){
        customer.getOrderHistory().addOrder(order);
        gom.addOrder(order);
    }
    
}
