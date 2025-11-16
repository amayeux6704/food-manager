
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexander
 */
public class PlaceOrderMenuManager {
    
    private OrderPlacer op;
    private Customer customer;
    private OrderManager gom;
    private Menu menu;
    private OrderAddressPlacer oap;
    private OrderPaymentPlacer opp;
    
    public PlaceOrderMenuManager(Customer customer, OrderManager gom, Menu menu){
        this.customer = customer;
        this.gom = gom;
        this.menu = menu;
        op = new OrderPlacer(this.customer, this.gom, this.menu);
        op.initializeOrder(menu);
        oap = new OrderAddressPlacer(this.customer, op);
        opp = new OrderPaymentPlacer(this.customer, op);
        
    }
    
    public void addDishes(){
        Scanner input = new Scanner(System.in);
        char cont;
        
        do{
            int id;
            
            System.out.print("Please enter the ID of the dish you wish to add to your order: ");
            id = input.nextInt();
            searchDishToAdd(id);
            
            System.out.print("Would you like to add any other dishes to your order? y/n: ");
            input.nextLine();
            cont = input.nextLine().charAt(0);
        }
        while(cont == 'y');
    }
    
    public void addSides(){
        Scanner input = new Scanner(System.in);
        char cont;
        
        do{
            int id;
            
            System.out.print("Please enter the name of the side you wish to add to your order: ");
            id = input.nextInt();
            searchDishToAdd(id);
            
            System.out.print("Would you like to add any other sides to your order? y/n: ");
            input.nextLine();
            cont = input.nextLine().charAt(0);
        }
        while(cont == 'y');
    }
    
    public void removeDishes(){
        Scanner input = new Scanner(System.in);
        char cont;
        
        do{
            int id;
            
            System.out.print("Please enter the ID of the dish you wish to remove from your order: ");
            id = input.nextInt();
            searchDishToRemove(id);
            
            System.out.print("Would you like to remove any other dishes to your order? y/n: ");
            input.nextLine();
            cont = input.nextLine().charAt(0);
        }
        while(cont == 'y');
    }
    
    public void removeSides(){
        Scanner input = new Scanner(System.in);
        char cont;
        
        do{
            int id;
            
            System.out.print("Please enter the name of the side you wish to remove from your order: ");
            id = input.nextInt();
            searchDishToRemove(id);
            
            System.out.print("Would you like to remove any other sides from your order? y/n: ");
            input.nextLine();
            cont = input.nextLine().charAt(0);
        }
        while(cont == 'y');
    }
    
    public void searchDishToAdd(int id){
        Scanner input = new Scanner(System.in);
        
        if(menu.findDish(id) != null){
            int num;
            
            System.out.print("How many of these would you like to add to your order?: ");
            num = input.nextInt();
            
            if(num > 0){
                op.addItem(id, num);
                System.out.println("Dish has been added successfully!\n");
            }
        }
        else{
            System.out.println("That dish does not exist.\n");
        }
    }
    
     public void searchDishToRemove(int id){
        Scanner input = new Scanner(System.in);
        
        if(menu.findDish(id) != null){
            
            op.removeItem(id);
            System.out.println("Dish has been removed successfully!\n");
            
        }
        else{
            System.out.println("That dish does not exist.\n");
        }
    }
    
    public boolean finishOrder(){
        
        if(confirmOrder()){
            oap.setAddress();
            opp.setPayment();
            System.out.println("");
            
            placeOrder();
            
            Scanner input = new Scanner(System.in);
            System.out.println("<<Press enter to continue>>");
            input.nextLine();
            
            return true;
        }
        else{
            return false;
        }    
    }
     
    public boolean confirmOrder(){
        showOrderReceipt();
        Scanner input = new Scanner(System.in);
        char choice;
        System.out.print("Are you ready to place this order? y/n: ");
        choice = input.nextLine().charAt(0);
        
        if(choice == 'y'){return true;}
        else{
            System.out.println("Operation cancelled.\n");
            return false;
        }
    }
    
    public void placeOrder(){
        op.placeOrder();
    }
    
    public void showOrderReceipt(){
        op.showReciept();
    }
    
}
