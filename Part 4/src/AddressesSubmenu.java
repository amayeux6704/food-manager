
import java.util.Scanner;

/**
 * This class provides a command line interface menu for a customer user to 
 * manage the information about the delivery addresses that they have stored
 * on their profile.
 * @author Alexander
 */
public class AddressesSubmenu implements ProgramMenu{
    
    /**
     * The instance of the addresses sub menu manager that manages all of the 
     * functionality of this sub menu. 
     */
    private AddressesSubmenuManager asm;
    
    /**
     * Class constructor that initializes the asm variable to a new 
     * AddressesSubmenuManager object, passing the customer as the argument to
     * the constructor.
     * 
     * @param customer  The customer who is logged in to the system.
     */
    public AddressesSubmenu(Customer customer){
        asm = new AddressesSubmenuManager(customer);
    }
    
    /**
     * This method displays the manage addresses sub menu to the user.
     */
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Manage Addresses:\n"+
                               "______________________________________________\n"+
                               "1. Show All Addresses\n"+
                               "2. Change Primary Address\n" +
                               "3. Add New Address\n"+
                               "4. Update Address\n" +
                               "5. Remove Address\n" +
                               "6. Return to Previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    asm.showAllAddresses();
                    break;
                case 2:
                    asm.changePrimary();
                    break;
                case 3:
                    asm.addNewAddress();
                    break;
                case 4:
                    asm.updateAddress();
                    break;
                case 5:
                    asm.removeAddress();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 6);
    }
}
