
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class GuestSubmenu implements ProgramMenu{
    
    private Menu menu;
    
    public GuestSubmenu(){
        menu = new Menu();
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
                               "3. Return to previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    break;
                case 2:
                    menu.menuDisplay();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 3);
    }
}
