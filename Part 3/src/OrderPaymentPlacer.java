
import java.util.Scanner;


/**
 *
 * @author Alexander
 */
public class OrderPaymentPlacer {
    
    private Customer customer;
    private OrderPlacer op;
    
    public OrderPaymentPlacer(Customer customer, OrderPlacer op){
        this.customer = customer;
        this.op = op;
    }
    
    public void setPayment(){
        Scanner input = new Scanner(System.in);
        char choice;
        String payment;
        
        if(!customer.getPayment().getPayMethods().isEmpty() &&
            customer.getPayment().getCurrentPayMethod() != null){
            
            System.out.print("Do you want to use your current payment method? y/n: ");
            choice = input.nextLine().charAt(0);
            
            if(Character.toLowerCase(choice) == 'n'){
               setOtherPayMethod();
            }
        }
        else{
            setOtherPayMethod();
        }
        
        payment = getCurrentPayMethod();
        op.setPayment(payment);
    }
    
    public String getCurrentPayMethod(){
        return customer.getPayment().getCurrentPayMethod();
    }
    
    public void setOtherPayMethod(){
        Scanner input = new Scanner(System.in);
        char choice;
        
        if(!customer.getPayment().getPayMethods().isEmpty()){
            System.out.print("Would you like to use an already existing payment method? y/n: ");
            choice = input.nextLine().charAt(0);
            
            if(Character.toLowerCase(choice) == 'n'){
                setNewPayMethod();
            }
            enterPayMethod();
            
        }
        else{
            setNewPayMethod();
            enterPayMethod();
        }
    }
    
    public void setNewPayMethod(){
        Scanner input = new Scanner(System.in);
        String payMethod;
        System.out.print("Please enter the payment method you want to add: ");
        payMethod = input.nextLine();
        
        customer.getPayment().addPayMethod(payMethod);
        
    }
    
    public void enterPayMethod(){
        Scanner input = new Scanner(System.in);
        String payMethod;
        do{
            for(String storedPayMethod: customer.getPayment().getPayMethods()){
                System.out.println("\n--- Payment Methods---");
                System.out.println("- " + storedPayMethod);
            }
            
            System.out.print("Please enter the payment method you want to use: ");
            payMethod = input.nextLine();
        }
        while(customer.getPayment().getPayMethods().contains(payMethod));
        customer.getPayment().setCurrentPayMethod(payMethod);
    }
}
