
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
class Order {
    private int OrderID;
    private ArrayList<String> contents;
    private String time;
    private String date;
    private Customer customer;
    private Address address;
    private DeliveryPerson deliveryPerson;
    
    public int getOrderId(){return this.OrderID;}
    
    public String getTime(){return this.time;}
    
    public String getDate(){return this.date;}
    
    public Customer getCustomer(){return this.customer;}
    
    public Address getAddress() {return this.address;}
    
    public DeliveryPerson getDeliveryPerson(){return this.deliveryPerson;}
    
    public void setTime(String time){this.time = time;}
    
    public void setDate(String date){this.date = date;}
    
    public void setCustomer(Customer customer){this.customer = customer;}
    
    public void setAddress(Address address){this.address = address;}
    
    public void setDeliveryPerson(DeliveryPerson DP){this.deliveryPerson = DP;}
    
    public void addDish(){
        
    }
    
    public void removeDish(){
        
    }
    
    public void displayContents(){
        
    }
    
    public double getTotalCost(){
        return 0.0;
    }
    
}
