
/**
 *
 * @author Alexander
 */
class Address {
    private int addressID;
    private String addressLine1, addressLine2, city, state, zipCode;
    private Customer customer;
    
    public String getLine1() {return addressLine1;}
    
    public String getLine2() {return addressLine2;}
    
    public String getCity() {return city;}
    
    public String getState() {return state;}
    
    public String getZipCode() {return zipCode;}
    
    public void setLine1(String line1) {this.addressLine1 = line1;}
    
    public void setLine2(String line2) {this.addressLine1 = line2;}
    
    public void setCity(String city) {this.addressLine1 = city;}
    
    public void setState(String state) {this.addressLine1 = state;}
    
    public void setZip(String zip) {this.addressLine1 = zip;}
    
    public void showAddress(){
        System.out.println(addressLine1 + "\n" +
                           addressLine2 + "\n" +
                           city + ", " + state + zipCode);
    }
    
}

