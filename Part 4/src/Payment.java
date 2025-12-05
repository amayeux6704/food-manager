/** Manages payment methods
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class Payment {

    private Set<String> paymentMethods;
    private String currentPaymentMethod;

    public Payment(String currentPaymentMethod){
        this.paymentMethods = new HashSet<>();
        this.currentPaymentMethod = currentPaymentMethod;
    }

/**
 * Gets the payment methods
 * @return The set of payment methods
 */
    public Set<String> getPayMethods(){
        return paymentMethods;
    }

/**
 * Gets the current payment method
 * @return The current payment method
 */
    public String getCurrentPayMethod(){
        return currentPaymentMethod;
    }

/**
 * Sets the current payment method
 * @param givenMethod A string representing the payment method selected
 */
    public void setCurrentPayMethod(String givenMethod){
        String potentialNewMethod = givenMethod.toLowerCase();
        if (paymentMethods.contains(potentialNewMethod)){
            this.currentPaymentMethod = potentialNewMethod;
            System.out.println("Current payment method is now: " + potentialNewMethod);
        } else {
            System.out.println("The Given method does not exist");
        }
    }

/**
 * Adds a payment method to the set of payment methods
 * @param newMethod A string representing a new payment method
 */
    public void addPayMethod(String newMethod){
        if (paymentMethods.contains(newMethod.toLowerCase())){
            System.out.println("This method already exists.");
        } else {
            paymentMethods.add(newMethod.toLowerCase());
            System.out.println(newMethod.toLowerCase() + " payment method added.");
        }
    }

/**
 * Removes a payment method from the set of payment methods
 * @param methodForRemoval A string representing the payment method to be removed
 */
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
