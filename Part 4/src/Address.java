
/**
 * This class stores and handles the information about an address associated 
 * with a customer.
 * @author Alexander
 */
class Address {
    /**
     * And ID number to be used to identify the address.
     */
    private int id;
    
    /**
     * String variables to store the address line 1, address line 2, city,
     * state, and zip code.
     */
    private String line1, line2, city, state, zipCode;
    
    /**
     * The customer associated with the address.
     */
    private Customer customer;
    
    /**
     * A Boolean variable to be used to determine whether the address is the 
     * customer's primary address.
     */
    private boolean primary;
    
    /**
     * Class constructor that assigns the customer and address ID to the address
     * based on the input parameters.
     * 
     * @param customer  The customer associated with the address.
     * @param id        The address ID.
     */
    public Address(Customer customer, int id){
        this.id = id;
        this.customer = customer;
    }
    
    /**
     * This method returns the ID number associated with this address.
     * 
     * @return The ID number associated with this address. 
     */
    public int getAddressID(){return this.id;}
    
    /**
     * This method sets the ID number of this address based on the input
     * parameter.
     * 
     * @param id The ID number to be assigned to this address.
     */
    public void setAddressID(int id){this.id = id;}
    
    /**
     * This method returns the address line 1 associated with this address.
     * 
     * @return  The address line 1 associated with this address.
     */
    public String getLine1() {return line1;}
    
    /**
     * This method returns the address line 2 associated with this address.
     * 
     * @return  The address line 2 associated with this address. 
     */
    public String getLine2() {return line2;}
    
    /**
     * This method returns the city associated with this address.
     * 
     * @return  The city associated with this address. 
     */
    public String getCity() {return city;}
    
    /**
     * This method returns the state associated with this address.
     * 
     * @return  The state associated with this address.
     */
    public String getState() {return state;}
    
    /**
     * This method returns the zip code associated with this address.
     * 
     * @return The zip code associated with this address.
     */
    public String getZipCode() {return zipCode;}
    
    /**
     * This method returns the customer associated with this address.
     * 
     * @return The customer associated with this address. 
     */
    public Customer getCustomer() {return customer;}
    
    /**
     * This method returns the Boolean value that determines whether this
     * address is the customer's primary address.
     * 
     * @return The Boolean value that determines whether this address is the
     *         Customer's primary address.
     */
    public boolean isPrimary(){return primary;}
    
    /**
     * This method sets the address line 1 based on the input parameter.
     * 
     * @param line1 The address line 1 to be assigned to this address.
     */
    public void setLine1(String line1) {this.line1 = line1;}
    
    /**
     * This method sets the address line 2 based on the input parameter.
     * 
     * @param line2 The address line 2 to be assigned to this address.
     */
    public void setLine2(String line2) {this.line2 = line2;}
    
    /**
     * This method sets the city based on the input parameter.
     * 
     * @param city The city to be assigned to this address.
     */
    public void setCity(String city) {this.city = city;}
    
    /**
     * This method sets the state based on the input parameter.
     * 
     * @param state The state to be assigned to this address.
     */
    public void setState(String state) {this.state = state;}
    
    /**
     * This method sets the zip code based on the input parameter.
     * 
     * @param zip The zip code to be assigned to this address.
     */
    public void setZipCode(String zip) {this.zipCode = zip;}
    
    /**
     * This method sets the customer associated with this address based on the 
     * input parameter.
     * 
     * @param customer The customer to be assigned to this address.
     */
    public void setCustomer(Customer customer){this.customer = customer;}
    
    /**
     * This method sets the Boolean value to determine whether this address is 
     * the customer's primary address based on the input parameter.
     * 
     * @param primary The Boolean value to determine whether this address is the
     *                Customer's primary address.
     */
    public void setPrimary(boolean primary){this.primary = primary;}
    
    /**
     * This method formats and prints the full address information to the 
     * console. This includes the address's ID, whether the address is primary, 
     * as well as the name of the customer associated with the address.
     */
    public void showAddressInformation(){
        
        String primary = "";
        
        if(isPrimary()){primary = "(Primary)";}
        System.out.println( "Address " + getAddressID() + primary + ":\n" +
                            "______________________________________________\n"+
                            getCustomer().getName() + "\n" +
                            this);
        
    }
    
    /**
     * This method formats this address's information as a string to be used to
     * display the full address information. This includes the address's ID, 
     * whether the address is primary, as well as the name of the customer 
     * associated with the address. It then returns the formatted string 
     * containing all of the information associated with this address.
     * 
     * @return The formatted string (str) that contains all of the information
     *         associated with this address.
     */
    public String stringAddressInformation(){
        
        String primary = "";
        
        if(isPrimary()){primary = "(Primary)";}
        String str =  "<html>Address " + getAddressID() + primary + ":<br>" +
                            "______________________________________________<br>"+
                            getCustomer().getName() + "<br>" +
                            toString();
        
        return str;    
    }
    
    /**
     * This method formats the address lines, city, state, and zip code to a 
     * standard format as a string. If line 2 is empty, it ignores it and does 
     * not include an extra line. It assigns this format to one string, and 
     * returns that string containing the address information.
     * 
     * @return The string (str) that contains the formatted address.
     */
    public String toString(){
        
        String str = "<html>" + getLine1() + "<br>";
        if(!getLine2().equals(""))
        {str += getLine2() + "<br>";}
        str += getCity() + ", " + getState() + " " + getZipCode();
        
        return str;
    }
    
}

