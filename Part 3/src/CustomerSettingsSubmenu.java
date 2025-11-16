
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
                               "3. Update Password\n"+
                               "4. Manage Addresses\n"+
                               "5. Manage Phone Numbers\n"+
                               "6. Manage Payment Information\n"+
                               "7. Delete Account\n" +
                               "8. Return to Previous\n"+
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
                    PaymentManagementMenu pmm = new PaymentManagementMenu(customer.getPayment(), input);
                    pmm.showMenu();
                    break;
                case 7:
                    csm.removeCustomer(customerId);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 8 && cm.searchCustomer(customerId) != null);
    }
}
