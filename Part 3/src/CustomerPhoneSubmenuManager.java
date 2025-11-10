import java.util.Scanner;
/**
 *
 * @author Alexander
 */
public class CustomerPhoneSubmenuManager {
    
    private Customer customer;
    private PhoneNumberManager pm;
    
    public CustomerPhoneSubmenuManager(Customer customer){
        this.customer = customer;
        pm = customer.getPNM();
    }
    
    public void showAllPhoneNumbers(){
        
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
