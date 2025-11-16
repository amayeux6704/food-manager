
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class PlaceOrderMenu implements ProgramMenu{
    
    private Customer customer;
    private OrderManager gom;
    private Menu menu;
    private PlaceOrderMenuManager pomm;
    private boolean finishOrder;
    
    public PlaceOrderMenu(Customer customer, OrderManager gom, Menu menu){
        this.customer = customer;
        this.gom = gom;
        this.menu = menu;
        pomm = new PlaceOrderMenuManager(this.customer, this.gom, this.menu);
    }
    
    public void showMenu(){
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
                               "5. Continue to payment\n" +
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
