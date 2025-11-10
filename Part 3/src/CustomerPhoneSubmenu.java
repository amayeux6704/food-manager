
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class CustomerPhoneSubmenu implements ProgramMenu{
    
    private CustomerPhoneSubmenuManager cpsm;
    private Customer customer;
    
    public CustomerPhoneSubmenu(Customer customer){
        this.customer = customer;
        cpsm = new CustomerPhoneSubmenuManager(customer);
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Manage Phone Numbers:\n"+
                               "______________________________________________\n"+
                               "1. Show All Phone Numbers\n"+
                               "2. Add New Phone Number\n"+
                               "3. Update Phone Number\n" +
                               "4. Remove Phone Number\n" +
                               "5. Return to Previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    cpsm.showAllPhoneNumbers();
                    break;
                case 2:
                    cpsm.addPhoneNumber();
                    break;
                case 3:
                    cpsm.updatePhoneNumber();
                    break;
                case 4:
                    cpsm.removePhoneNumber();
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
