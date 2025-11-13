/**
 *
 * @author Alexander
 */
public class Main {
    public static void main(String[] args){
        
        CustomerManager customerManager = new CustomerManager();
        DeliveryPersonManager deliveryPersonManager = new DeliveryPersonManager();
        
        MainMenu mainMenu = new MainMenu(customerManager, deliveryPersonManager);
        mainMenu.showMenu();
    }
}
