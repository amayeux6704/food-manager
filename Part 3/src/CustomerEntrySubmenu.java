
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class CustomerEntrySubmenu implements ProgramMenu{
    
    private CustomerManager cm;
    private CustomerSubmenu cs;
    private GuestSubmenu gs;
    private AccountScreen as;
    
    public CustomerEntrySubmenu(){
        cm = new CustomerManager();
        as = new AccountScreen(cm);
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Customer Entry:\n"+
                               "______________________________________________\n"+
                               "1. Login\n"+
                               "2. Sign Up\n"+
                               "3. Order as Guest\n"+
                               "4. Back to Main\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            Customer customer = null;
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    customer = as.logIn();
                    break;
                case 2:
                    customer = as.signUp();
                    break;
                case 3:
                    customer = as.guest();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
            if(customer != null){
                if(!customer.isGuest()){
                    cs = new CustomerSubmenu(cm, customer.getID());
                    cs.showMenu();
                }
                else{
                    gs = new GuestSubmenu();
                    gs.showMenu();
                }
            }
        }
        while(choice != 4);
    }
}
