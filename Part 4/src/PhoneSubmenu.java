
import java.util.Scanner;

/**
 * This class provides a command line interface menu for a user to manage their 
 * phone numbers that they have stored on their profile either as a customer or 
 * employee.
 * @author Alexander
 */
public class PhoneSubmenu implements ProgramMenu{
    
    /**
     * The instance of the phone sub menu manager that manages all of the 
     * functionality of this sub menu. 
     */
    private PhoneSubmenuManager psm;
    
    /**
     * Class constructor that initializes the psm variable to a new 
     * PhoneSubmenuManager object, passing the person as the argument to
     * the constructor.
     * @param person The person user who is currently logged in.
     */
    public PhoneSubmenu(Person person){
        psm = new PhoneSubmenuManager(person);
    }
    
    /**
     * This method displays the manage phone numbers sub menu to the user.
     */
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
                    psm.showAllPhoneNumbers();
                    break;
                case 2:
                    psm.addPhoneNumber();
                    break;
                case 3:
                    psm.updatePhoneNumber();
                    break;
                case 4:
                    psm.removePhoneNumber();
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
