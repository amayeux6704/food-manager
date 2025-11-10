
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class AddressesSubmenu implements ProgramMenu{
    
    private Customer customer;
    private AddressesSubmenuManager asm;
    
    public AddressesSubmenu(Customer customer){
        this.customer = customer;
        asm = new AddressesSubmenuManager(customer);
    }
    
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
