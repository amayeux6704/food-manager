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
    private PlaceOrderMenu orderMenu;
    
    public CustomerSubmenuManager(CustomerManager cm, Customer customer, OrderManager gom, Menu menu, 
            Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this.cm = cm;
        this.customer = customer;
        this.om = customer.getOrderHistory();
        this.menu = menu;
        css = new CustomerSettingsSubmenu(this.cm, this.customer.getID());
        orderMenu = new PlaceOrderMenu(this.customer, gom, this.menu, cc);
    }
    
    
    public void placeOrder(){
       orderMenu.showMenu();
    }
    
    public void viewMenu(){
        menu.menuDisplay();
    }
    
    public void showOrderHistory(){
        om.showOrderHistory();
    }
    
    public void profileSettings(){
        if(!customer.isGuest())
            css.showMenu();
        else
            System.out.println("This option is reserved for customers with a user profile.\n");
    }
    
    public void showCurrentOrders(){
        om.showUnfulfilledOrders();
    }
}
