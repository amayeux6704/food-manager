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
        Inventory inventory = new Inventory();
        Restaurant restaurant = new Restaurant("Restaurant");
        CostCalculation costCalculation = new CostCalculation();
        
        InitialDataGenerator idg = new InitialDataGenerator(customerManager, deliveryPersonManager, 
                generalOrderManager, menu, restaurant, inventory, costCalculation);
        
        idg.generateDummyData();
        
        MainMenu mainMenu = new MainMenu(customerManager, deliveryPersonManager, generalOrderManager, menu,
                                        restaurant, inventory, costCalculation);
        mainMenu.showMenu();
    }
}
