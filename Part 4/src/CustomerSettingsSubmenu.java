
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
        as = new AddressesSubmenu(customer);
        ps = new PhoneSubmenu(customer);
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
                               "3. Update Email\n" +
                               "4. Update Password\n"+
                               "5. Manage Addresses\n"+
                               "6. Manage Phone Numbers\n"+
                               "7. Manage Payment Information\n"+
                               "8. Delete Account\n" +
                               "9. Return to Previous\n"+
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
                    csm.updateEmail(customerId);
                    break;
                case 4:
                    csm.updatePassword(customerId);
                    break;
                case 5:
                    as.showMenu();
                    break;
                case 6:
                    ps.showMenu();
                    break;
                case 7:
                    PaymentManagementMenu pmm = new PaymentManagementMenu(customer.getPayment(), input);
                    pmm.showMenu();
                    break;
                case 8:
                    csm.removeCustomer(customerId);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 9 && cm.searchCustomer(customerId) != null);
    }
}
