
/**
 *
 * @author Alexander
 */
class Address {
    private int id;
    private String line1, line2, city, state, zipCode;
    private Customer customer;
    private boolean primary;
    
    public Address(Customer customer, int id){
        this.id = id;
        this.customer = customer;
    }
    
    public int getAddressID(){return this.id;}
    
    public void setAddressID(int id){this.id = id;}
    
    public String getLine1() {return line1;}
    
    public String getLine2() {return line2;}
    
    public String getCity() {return city;}
    
    public String getState() {return state;}
    
    public String getZipCode() {return zipCode;}
    
    public Customer getCustomer() {return customer;}
    
    public boolean isPrimary(){return primary;}
    
    public void setLine1(String line1) {this.line1 = line1;}
    
    public void setLine2(String line2) {this.line2 = line2;}
    
    public void setCity(String city) {this.city = city;}
    
    public void setState(String state) {this.state = state;}
    
    public void setZipCode(String zip) {this.zipCode = zip;}
    
    public void setCustomer(Customer customer){this.customer = customer;}
    
    public void setPrimary(boolean primary){this.primary = primary;}
    
    public void showAddressInformation(){
        
        String primary = "";
        
        if(isPrimary()){primary = "(Primary)";}
        System.out.println( "Address " + getAddressID() + primary + ":\n" +
                            "______________________________________________\n"+
                            getCustomer().getName() + "\n" +
                            this);
        
    }
    
    public String toString(){
        
        String str = getLine1() + "\n";
        if(!getLine2().equals(""))
        {str += getLine2();}
        str += getCity() + ", " + getState() + " " + getZipCode();
        
        return str;
    }
    
}

