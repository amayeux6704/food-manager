
/**
 *
 * @author Alexander
 */
class Vehicle {
    private int vehicleID;
    private String make, model, color, bodyStyle, licensePlate;
    private short year;
    private DeliveryPerson employee;
    
    public Vehicle(){
        
    }
    
    public int getVehicleID(){return this.vehicleID;}
    
    public String getMake(){return this.make;}
    
    public String getModel(){return this.model;}
    
    public short getYear(){return this.year;}
    
    public String getColor(){return this.color;}
    
    public String getBodyStyle(){return this.bodyStyle;}
    
    public String getLicensePlate(){return this.licensePlate;}
    
    public void setMake(String make){this.make = make;}
    
    public void setModel(String model){this.model = model;}
    
    public void setYear(short year){this.year = year;}

    public void setColor(String color){this.color = color;}
    
    public void setBodyStyle(String bodyStyle){this.bodyStyle = bodyStyle;}

    public void setLicensePlate(String licensePlate){this.licensePlate = licensePlate;} 
    
}
