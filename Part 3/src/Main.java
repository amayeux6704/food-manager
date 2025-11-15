/**
 *
 * @author Alexander
 */
public class Main {
    public static void main(String[] args){
        
        CustomerManager customerManager = new CustomerManager();
        DeliveryPersonManager deliveryPersonManager = new DeliveryPersonManager();
        OrderManager generalOrderManager = new OrderManager();
        Menu menu = new Menu();
        
        InitialDataGenerator idg = new InitialDataGenerator(customerManager, deliveryPersonManager, generalOrderManager, menu);
        
        idg.generateDummyData();
        
        MainMenu mainMenu = new MainMenu(customerManager, deliveryPersonManager, generalOrderManager, menu);
        mainMenu.showMenu();
    }
}
