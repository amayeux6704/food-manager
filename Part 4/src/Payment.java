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

    public void setCurrentPayMethod(String givenMethod){
        String potentialNewMethod = givenMethod.toLowerCase();
        if (paymentMethods.contains(potentialNewMethod)){
            this.currentPaymentMethod = potentialNewMethod;
            System.out.println("Current payment method is now: " + potentialNewMethod);
        } else {
            System.out.println("The Given method does not exist");
        }
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
        String method = methodForRemoval.toLowerCase();
        if (paymentMethods.contains(methodForRemoval.toLowerCase())){
            if (method.equals(this.currentPaymentMethod)){
                System.out.println("Method selected is set as the current method and can not be removed");
                return;
            }
            paymentMethods.remove(methodForRemoval.toLowerCase());
            System.out.println(methodForRemoval.toLowerCase() + " payment method removed.");
        } else {
            System.out.println("Method does not exist.");
        }
    }
}
