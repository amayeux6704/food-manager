
/**
 * This class stores and handles the information about a delivery person's
 * delivery vehicle.
 * 
 * @author Alexander
 */
class Vehicle {
    /**
     * The ID number to be used to identify the vehicle.
     */
    private int vehicleID;
    /**
     * String variables to be used to store the vehicle's make, model, color, 
     * body style, and license plate.
     */
    private String make, model, color, bodyStyle, licensePlate;
    /**
     * A short variable that stores the year of the vehicle.
     */
    private short year;
    /**
     * The delivery person associated with the vehicle.
     */
    private DeliveryPerson employee;
    
    /**
     * Class constructor that assigns the employee and vehicle ID associated
     * with the vehicle based on the input parameters.
     * 
     * @param employee  The employee associated with the vehicle.
     * @param vehicleID The ID number to be assigned to the vehicle.
     */
    public Vehicle(DeliveryPerson employee, int vehicleID){
        this.employee = employee;
        this.vehicleID = vehicleID;
    }
    
    /**
     * This method returns the vehicle's ID number.
     * 
     * @return The vehicle's ID number.
     */
    public int getVehicleID(){return this.vehicleID;}
    
    /**
     * This method returns the vehicle's make.
     * 
     * @return The vehicle's make.
     */
    public String getMake(){return this.make;}
    
    /**
     * This method returns the vehicle's model.
     * 
     * @return The vehicle's model.
     */
    public String getModel(){return this.model;}
    
    /**
     * This method returns the vehicle's year.
     * 
     * @return The vehicle's year.
     */
    public short getYear(){return this.year;}
    
    /**
     * This method returns the vehicle's color.
     * 
     * @return The vehicle's color.
     */
    public String getColor(){return this.color;}
    
    /**
     * This method returns the vehicle's body style.
     * 
     * @return The vehicle's body style.
     */
    public String getBodyStyle(){return this.bodyStyle;}
    
    /**
     * This method returns the vehicle's license plate number.
     * 
     * @return The vehicle's license plate number.
     */
    public String getLicensePlate(){return this.licensePlate;}
    
    /**
     * This method returns the employee associated with the vehicle.
     * 
     * @return The employee associated with the vehicle.
     */
    public DeliveryPerson getEmployee(){return this.employee;}
    
    /**
     * This method sets the vehicle's ID number based on the input parameter.
     * 
     * @param make The make to be assigned to the vehicle.
     */
    public void setMake(String make){this.make = make;}
    
    /**
     * This method sets the vehicle's model based on the input parameter.
     * 
     * @param model The model to be assigned to the vehicle.
     */
    public void setModel(String model){this.model = model;}
    
    /**
     * This method sets the vehicle's year based on the input parameter.
     * 
     * @param year The year to be assigned to the vehicle.
     */
    public void setYear(short year){this.year = year;}

    /**
     * This method sets the vehicle's color based on the input parameter.
     * 
     * @param color The color to be assigned to the vehicle.
     */
    public void setColor(String color){this.color = color;}
    
    /**
     * This method sets the vehicle's body style based on the input parameter.
     * 
     * @param bodyStyle The body style to be assigned to the vehicle
     */
    public void setBodyStyle(String bodyStyle){this.bodyStyle = bodyStyle;}

    /**
     * This method sets the vehicle's license plate based on the input parameter.
     * 
     * @param licensePlate The license plate number to be assigned to the 
     *                     vehicle.
     */
    public void setLicensePlate(String licensePlate){this.licensePlate = licensePlate;} 
    
    /**
     * This method format's the vehicle's information into a string to be
     * displayed within the system. 
     * 
     * @return The formatted string (str) containing the vehicle's information.
     */
    @Override
    public String toString(){
        String str = "<html>Vehicle: " + getYear() + " " + getMake() + " " + getModel() + "<br>" +
                     "Color: " + getColor() + "<br>" +
                     "Body Style: " + getBodyStyle() + "<br>" + 
                     "License plate: " + getLicensePlate() + "<br>";
        
        return str;
    }
}
