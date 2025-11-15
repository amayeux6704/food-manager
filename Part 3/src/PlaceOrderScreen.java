
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class PlaceOrderScreen {
    
    private OrderPlacer op;
    private Customer customer;
    private OrderManager gom;
    private Menu menu;
    
    public PlaceOrderScreen(Customer customer, OrderManager gom, Menu menu){
        this.customer = customer;
        this.gom = gom;
        this.menu = menu;
        
        op = new OrderPlacer(this.customer, this.gom, this.menu);
    }
    
    public void showScreen(){
        op.initializeOrder(menu);
        getContents();
        if(op.getNumItems() > 0 && confirmOrder()){
            getPayment();
            getAddress();
            placeOrder();
        }
    }
    
    public void getContents(){
        Scanner input = new Scanner(System.in);
        char cont;
        
        do{
            int id;
            
            System.out.print("Please enter the ID of the item you wish to add to your order: ");
            id = input.nextInt();
            searchDishToAdd(id);
            
            System.out.print("Would you like to add anything else to your order? y/n: ");
            input.nextLine();
            cont = input.nextLine().charAt(0);
        }
        while(cont == 'y');
    }
    
    public void getPayment(){
        op.setPayment();
    }
    
    public void placeOrder(){
        op.placeOrder();
    }
    
    public void searchDishToAdd(int id){
        Scanner input = new Scanner(System.in);
        
        if(menu.findDish(id) != null){
            int num;
            
            System.out.print("How many of these would you like to add to your order?: ");
            num = input.nextInt();
            
            if(num > 0){
                op.addItem(id, num);
                System.out.println("Item has been added successfully!\n");
            }
        }
        else{
            System.out.println("That dish does not exist.\n");
        }
    }

    public boolean confirmOrder(){
        showOrder();
        Scanner input = new Scanner(System.in);
        char choice;
        System.out.print("Are you ready to place this order? y/n: ");
        choice = input.nextLine().charAt(0);
        
        if(choice == 'y'){return true;}
        else{
            System.out.println("Order cancelled.\n");
            return false;
        }
    }
    
    public void showOrder(){
        op.showReciept();
    }

    public void getAddress() {
        Scanner input = new Scanner(System.in);
        char choice;
        
        System.out.print("Would you like to use your primary address? y/n: ");
        
        choice = input.nextLine().charAt(0);
        
        int id;
        
        if(Character.toLowerCase(choice) == 'y'){
            id = customer.getAddressManager().getPrimaryAddressID();
        }
        else{
            customer.getAddressManager().showAddresses();
            System.out.print("Please enter the ID of the address you want your order sent to: ");
            id = input.nextInt();
        }
        
        op.setAddress(id);
    }
}
