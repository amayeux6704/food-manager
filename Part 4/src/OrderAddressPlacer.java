
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class OrderAddressPlacer {
    
    private Customer customer;
    private OrderPlacer op;
    
    public OrderAddressPlacer(Customer customer, OrderPlacer op){
        this.customer = customer;
        this.op = op;
    }
    
    public void setAddress() {
        Scanner input = new Scanner(System.in);
        char choice;
        boolean validAddress = false;
        
        int id;
        
        if(customer.getAddressManager().hasPrimaryAddress()){
            System.out.print("Would you like to use your primary address? y/n: ");
        
            choice = input.nextLine().charAt(0);
        
            if(Character.toLowerCase(choice) == 'y'){
                id = usePrimaryAddress();
            }
            else{
                id = useDifferentAddress();
            }
        }
        else{
            id = useDifferentAddress();
        }
        
        op.setAddress(id);
    }
    
    public int usePrimaryAddress(){
        int id = customer.getAddressManager().getPrimaryAddressID();
        return id;
    }
    
    public int useDifferentAddress(){
        Scanner input = new Scanner(System.in);
        char choice;
        int id;
        
        if(customer.getAddressManager().hasAddresses()){
            System.out.print("Would you like to use an already existing address? y/n: ");
         
            choice = input.nextLine().charAt(0);
            if(Character.toLowerCase(choice) == 'n'){
                createNewAddress();
            }
            id = enterAddressID();
        }
        else{
            createNewAddress();
            id = enterAddressID();
        }
        return id;
    }
    
    public void createNewAddress(){
        AddressesSubmenuManager asm = new AddressesSubmenuManager(customer);
        asm.addNewAddress();
    }
    
    public int enterAddressID(){
        int id;
        do{
            Scanner input = new Scanner(System.in);
            customer.getAddressManager().showAddresses();
            System.out.print("Please enter the ID of the address you want your order sent to: ");
            id = input.nextInt();
        }
        while(customer.getAddressManager().searchAddress(id) == null);
        return id;
    }
}
