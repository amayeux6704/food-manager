/**
 *
 * @author Alexander
 */
public class CustomerSubmenuManager {
    private CustomerManager cm;
    private Customer customer;
    private OrderManager om;
    private Menu menu;
    private CustomerSettingsSubmenu css;
    private PlaceOrderScreen orderScreen;
    
    public CustomerSubmenuManager(CustomerManager cm, Customer customer, OrderManager gom, Menu menu){
        this.cm = cm;
        this.customer = customer;
        this.om = customer.getOrderHistory();
        this.menu = menu;
        css = new CustomerSettingsSubmenu(this.cm, this.customer.getID());
        orderScreen = new PlaceOrderScreen(this.customer, gom, this.menu);
    }
    
    
    public void placeOrder(){
       orderScreen.showScreen();
    }
    
    public void viewMenu(){
        menu.menuDisplay();
    }
    
    public void showOrderHistory(){
        om.showOrderHistory();
    }
    
    public void profileSettings(){
        css.showMenu();
    }
    
    public void showCurrentOrders(){
        om.showUnfulfilledOrders();
    }
}
