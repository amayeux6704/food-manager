public class PaymentMethod {

    private String name;

    public PaymentMethod(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Overide
    public String toString(){

    }
}
