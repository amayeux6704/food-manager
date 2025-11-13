import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Alexander
 */
public class PhoneSubmenuManager {
    
    private Person person;
    private PhoneNumberManager pm;
    
    public PhoneSubmenuManager(Person person){
        this.person = person;
        pm = person.getPNM();
    }
    
    public void showAllPhoneNumbers(){
        Set<String> phoneNumbers = pm.getPhoneNumbers();
        
        if(phoneNumbers.isEmpty()){
            System.out.println("There are no phone numbers associated with this user.\n");
        }
        else{
            System.out.println("Phone Numbers:\n"+
                               "______________________________________________\n");
            for(String phoneNumber: phoneNumbers){
                System.out.println(" * " + phoneNumber + "\n");
            }
        }
    }
    
    public void addPhoneNumber(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the phone number you would like to add: ");
        String phone = input.nextLine();
        
        pm.addPhoneNumber(phone);
    }
    
    public void updatePhoneNumber(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the phone number you would like to update: ");
        String oldPhone = input.nextLine();
        
        System.out.print("Please enter the updated phone number: ");
        String newPhone = input.nextLine();
        
        pm.updatePhoneNumber(oldPhone, newPhone);
    }
    
    public void removePhoneNumber(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the phone number you would like to remove: ");
        String phone = input.nextLine();
        
        pm.removePhoneNumber(phone);
    }
    
}
