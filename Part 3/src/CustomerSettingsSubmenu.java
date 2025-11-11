
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class CustomerSettingsSubmenu implements ProgramMenu{
    
    private CustomerSettingsManager csm;
    private CustomerManager cm;
    private Customer customer;
    private AddressesSubmenu as;
    private PhoneSubmenu ps;
    private int customerId;
    
    public CustomerSettingsSubmenu(CustomerManager cm, int id){
        this.cm = cm;
        customerId = id;
        customer = cm.searchCustomer(id);
        csm = new CustomerSettingsManager(this.cm);
        as = new AddressesSubmenu(this.customer);
        ps = new PhoneSubmenu(this.customer);
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Settings\n"+
                               "______________________________________________\n"+
                               "1. View Customer Information\n"+
                               "2. Update Name\n"+
                               "3. Update Password\n"+
                               "4. Manage Addresses\n"+
                               "5. Manage Phone Numbers\n"+
                               "6. Delete Account\n" +
                               "7. Return to Previous\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            
            switch (choice){
                case 1:
                    csm.showCustomerInfo(customerId);
                    break;
                case 2:
                    csm.updateName(customerId);
                    break;
                case 3:
                    csm.updatePassword(customerId);
                    break;
                case 4:
                    as.showMenu();
                    break;
                case 5:
                    ps.showMenu();
                    break;
                case 6:
                    csm.removeCustomer(customerId);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 7 && cm.searchCustomer(customerId) != null);
    }
}
