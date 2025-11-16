
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class GuestSubmenu implements ProgramMenu{
    
    private Menu menu;
    private CustomerSubmenuManager csubm;
    private CustomerManager cm;
    private Customer guest;
    
    public GuestSubmenu(CustomerManager cm, int id, OrderManager gom, Menu menu){
        this.cm = cm;
        guest = this.cm.searchCustomer(id);
        this.menu = menu;
        csubm = new CustomerSubmenuManager(this.cm, guest, gom, this.menu);
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Welcome, Guest!\n"+
                               "What would you like to do today?\n"+
                               "______________________________________________\n"+
                               "1. Place an Order\n"+
                               "2. View Menu\n"+
                               "3. View Current Orders\n" +
                               "4. View Order History\n" +
                               "5. Return to previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    csubm.placeOrder();
                    break;
                case 2:
                    csubm.viewMenu();
                    break;
                case 3:
                    csubm.showCurrentOrders();
                    break;
                case 4:
                    csubm.showOrderHistory();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 5);
    }
}
