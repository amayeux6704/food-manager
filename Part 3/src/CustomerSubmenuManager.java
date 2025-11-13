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
    
    public CustomerSubmenuManager(CustomerManager cm, Customer customer){
        this.cm = cm;
        this.customer = customer;
        this.om = customer.getOrderHistory();
        menu = new Menu();
        css = new CustomerSettingsSubmenu(this.cm, this.customer.getID());
    }
    
    
    public void placeOrder(){
        
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
