import java.util.ArrayList;

public class Payment {

    private ArrayList<PaymentMethod> paymentMethods;
    private PaymentMethod currentPaymentMethod;

    public Payment(PaymentMethod currentPaymentMethod){
        this.paymentMethods = new ArrayList<>();
        this.currentPaymentMethod = currentPaymentMethod;
    }

    public ArrayList<PaymentMethod> getPayMethods(){
        return paymentMethods;
    }

    public PaymentMethod getCurrentPayMethod(){
        return currentPaymentMethod;
    }

    public void setCurrentPayMethod(PaymentMethod currentPaymentMethod){
        this.currentPaymentMethod = currentPaymentMethod;
    }

    public void addPayMethod(PaymentMethod newMethod){
        for (PaymentMethod method : paymentMethods) {
            if (method.equals(newMethod)){
                System.out.println("This method already exists.");
            } else {
                paymentMethods.add(newMethod);
                System.out.println(newMethod + " payment method added.");
            }
        }
    }

    public void removePayMethod(PaymentMethod methodForRemoval){
        for (PaymentMethod method : paymentMethods) {
            if (method.equals(methodForRemoval)){
                paymentMethods.remove(methodForRemoval);
                System.out.println(methodForRemoval + " payment method removed.");
            } else {
                System.out.println("Method does not exist.");
            }
        }
    }
}
