
import java.util.Scanner;

/**
 * This class provides a command line interface menu for a customer user to
 * place an order for delivery in the system.
 * @author Alexander
 */
public class PlaceOrderMenu implements ProgramMenu{
    
    /**
     * The place order menu manager that manages all of the functionality of 
     * this sub menu.
     */
    private PlaceOrderMenuManager pomm;
    
    /**
     * A Boolean variable to be used to determine if the customer has finished
     * placing their order.
     */
    private boolean finishOrder;
    
    /**
     * Class constructor that initializes the customer, general order manager, 
     * and menu based on the input parameters. It also initializes the pomm 
     * variable to be a new PlaceOrderMenuManager object, passing the customer,
     * gom, menu, cc, and inventory parameters as arguments to the constructor.
     * @param customer  The customer placing the order.
     * @param gom       The general order manager that stores and manages all of 
     *                  the orders within the system.
     * @param menu      The food menu that has all of the food items.
     * @param cc        The cost calculation object to calculate the cost of 
     *                  orders.
     * @param inventory The inventory of ingredients for each dish
     */
    public PlaceOrderMenu(Customer customer, OrderManager gom, Menu menu, CostCalculation cc,
            Inventory inventory){
        pomm = new PlaceOrderMenuManager(customer, gom, menu, cc, inventory);
    }
    
    /**
     * This method displays the place order menu to the user. If the order has
     * been complete, the menu will close and return to the customer sub menu.
     */
    public void showMenu(){
        pomm.createNewOrder();
        this.finishOrder = false;
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print(  "What would you like to do with your order?\n"+
                               "______________________________________________\n"+
                               "1. Add Dish\n"+
                               "2. Add Side\n"+
                               "3. Remove Dish\n" +
                               "4. Remove Side\n" +
                               "5. View/Continue to Place Order\n" +
                               "6. Cancel Order\n" +
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    pomm.addDishes();
                    break;
                case 2:
                    pomm.addSides();
                    break;
                case 3:
                    pomm.removeDishes();
                    break;
                case 4:
                    pomm.removeSides();
                    break;
                case 5:
                    finishOrder = pomm.finishOrder();
                    break;
                case 6:
                    System.out.println("Order cancelled.");
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 6 && !finishOrder);
    }
}
