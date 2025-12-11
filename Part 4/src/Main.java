/**
 * The main class that allows the program to run.
 * @author Alexander
 */
public class Main {
    /**
     * The main method.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        /**
         * The customer manager that stores and operates on the information 
         * of all of the customers within the system. This will be passed as an 
         * argument most of the time to grant other submenus access to it so 
         * they can operate on the data of customers. 
         */
        CustomerManager customerManager = new CustomerManager();
        /**
         * The delivery person manager that stores and operates on the 
         * information about all of the delivery people/employees within the 
         * system. This will be passed as an argument most of the time to grant 
         * other submenus access to it so they can operate on the data of 
         * employees. 
         */
        DeliveryPersonManager deliveryPersonManager = new DeliveryPersonManager();
        /**
         * The general order manager that stores and operates on all of the
         * orders placed by all of the customers in the system. This will be
         * passed as an argument most of the time so that other submenus can 
         * access the information about all of the orders that have been placed
         * in the system.
         */
        OrderManager generalOrderManager = new OrderManager();
        /**
         * The food menu that stores all of the food items avaiable for order.
         * This will be passed as an argument most of the time so that other
         * submenus can access information about the food items available for 
         * sale in the system.
         */
        Menu menu = new Menu();
        /**
         * The inventory of ingredients needed for each food item. This will
         * be passed as an argument most of the time so that other submenus
         * can access information about the inventory status of the system.
         */
        Inventory inventory = new Inventory();
        /**
         * The restaurant that sells the food items. This will be passed as an
         * argument most of the time so that other submenus can access
         * information about the restaurant's location and status.
         */
        Restaurant restaurant = new Restaurant("Restaurant");
        /**
         * The cost calculation object that calculates the cost of orders. This
         * will be passed as an argument most of the time so that there can be
         * a standardized tax rate and method of calculation throughout the 
         * system.
         */
        CostCalculation costCalculation = new CostCalculation();
        
        InitialDataGenerator idg = new InitialDataGenerator(customerManager, deliveryPersonManager, 
                generalOrderManager, menu, restaurant, inventory, costCalculation);
        
        idg.generateDummyData();
        
        /**
         * The main menu GUI object that displays the main menu to the user.
         */
        MainMenuGUI mmGUI = new MainMenuGUI(customerManager, deliveryPersonManager, generalOrderManager, menu,
                                        restaurant, inventory, costCalculation);
        
        MainMenu mainMenu = new MainMenu(customerManager, deliveryPersonManager, generalOrderManager, menu,
                                        restaurant, inventory, costCalculation);
        //mainMenu.showMenu();
        
        //Display the main menu to the user.
        mmGUI.setVisible(true);
    }
}
