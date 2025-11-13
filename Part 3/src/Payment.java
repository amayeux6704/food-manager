import java.util.HashSet;
import java.util.Set;

public class Payment {

    private Set<String> paymentMethods;
    private String currentPaymentMethod;

    public Payment(String currentPaymentMethod){
        this.paymentMethods = new HashSet<>();
        this.currentPaymentMethod = currentPaymentMethod;
    }

    public Set<String> getPayMethods(){
        return paymentMethods;
    }

    public String getCurrentPayMethod(){
        return currentPaymentMethod;
    }

    public void setCurrentPayMethod(String currentPaymentMethod){
        this.currentPaymentMethod = currentPaymentMethod;
    }

    public void addPayMethod(String newMethod){
        if (paymentMethods.contains(newMethod.toLowerCase())){
            System.out.println("This method already exists.");
        } else {
            paymentMethods.add(newMethod.toLowerCase());
            System.out.println(newMethod.toLowerCase() + " payment method added.");
        }
    }

    public void removePayMethod(String methodForRemoval){
        if (paymentMethods.contains(methodForRemoval.toLowerCase())){
            paymentMethods.remove(methodForRemoval.toLowerCase());
            System.out.println(methodForRemoval.toLowerCase() + " payment method removed.");
        } else {
            System.out.println("Method does not exist.");
        }
    }
}
