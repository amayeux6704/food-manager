
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class PhoneSubmenu implements ProgramMenu{
    
    private PhoneSubmenuManager psm;
    private Person person;
    
    public PhoneSubmenu(Person person){
        this.person = person;
        psm = new PhoneSubmenuManager(this.person);
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
