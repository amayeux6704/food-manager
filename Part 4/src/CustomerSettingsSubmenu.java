
import java.util.Scanner;

/**
 * This class provides a command line interface menu for a customer user to edit
 * the information associated with their profile.
 * 
 * @author Alexander
 */
public class CustomerSettingsSubmenu implements ProgramMenu{
    
    /**
     * The customer settings manager that manages all of the functionality of 
     * this settings sub menu.
     */
    private CustomerSettingsManager csm;
    
    /**
     * The customer manager being used throughout the system.
     */
    private CustomerManager cm;
    
    /**
     * The customer who is logged in to the system.
     */
    private Customer customer;
    
    /**
     * The instance of the addresses sub menu to manage address information.
     */
    private AddressesSubmenu as;
    
    /**
     * The instance of the phone sub menu to manage phone number information.
     */
    private PhoneSubmenu ps;
    
    /**
     * The ID associated with the customer logged in to the system.
     */
    private int customerId;
    
    /**
     * Class constructor that initializes the instance variables. It initializes
     * the cm and customerId variables based on their respective input
     * parameters. The customer associated with the input customer ID is
     * assigned to the customer variable. The csm variable is initialized to a
     * new CustomerSettingsManager() object, passing the cm as the argument. The
     * as is initialized to a new AddressesSubmenu() object, passing the 
     * customer as the argument. And finally, the ps is initialized to a new
     * PhoneSubmenu object, also passing the customer as an argument.
     * 
     * @param cm    The customer manager that is being used throughout the
     *              entire system.
     * @param id    The ID associated with the customer that is logged in.
     */
    public CustomerSettingsSubmenu(CustomerManager cm, int id){
        this.cm = cm;
        customerId = id;
        customer = cm.searchCustomer(id);
        csm = new CustomerSettingsManager(this.cm);
        as = new AddressesSubmenu(customer);
        ps = new PhoneSubmenu(customer);
    }
    
    /**
     * This method displays the customer settings sub menu to the user. If the 
     * customer decides to delete their profile, the menu will automatically 
     * return back to the customer sub menu, which will then return to the 
     * customer entry sub menu.
     */
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
