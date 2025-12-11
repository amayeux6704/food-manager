
import java.io.*;

/**
 *
 * @author Alexander
 */
public class LoadSaveDeliveryPerson {
    
    public DeliveryPerson LoadDeliveryPerson(int id){
        
        String fileName = "txtDataFiles/deliveryPersonFiles/dp" + id + ".txt";
        System.out.println(fileName);
        try{
            DeliveryPerson deliveryPerson;
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            String[] tempArr;
            
            //Load Customer name, id, email, guest status, and password,
            
            line = br.readLine();
            
            tempArr = line.split(",");
            
            String name = tempArr[0];
            int empId = Integer.parseInt(tempArr[1]);
            
            deliveryPerson = new DeliveryPerson(name, empId);
            deliveryPerson.setEmail(tempArr[2]);
            deliveryPerson.setPassword(tempArr[3]);
            
            while((line = br.readLine()) != null){
                
                tempArr = line.split(",");
                
                String type = tempArr[0];
                
                switch(type){
                    case "~v":
                        setVehicle(deliveryPerson, tempArr);
                        break;
                    case "~ph":
                        setPhone(deliveryPerson, tempArr);
                        break; 
                }
            }
            br.close();
            System.out.println(deliveryPerson);
            
            return deliveryPerson;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
    }

    
    private void setVehicle(DeliveryPerson deliveryPerson, String[] tempArr){
        int vehicleId = Integer.parseInt(tempArr[1]);
        Vehicle vehicle = new Vehicle(deliveryPerson, vehicleId);
        vehicle.setYear(Short.parseShort(tempArr[2]));
        vehicle.setMake(tempArr[3]);
        vehicle.setModel(tempArr[4]);
        vehicle.setColor(tempArr[5]);
        vehicle.setBodyStyle(tempArr[6]);
        vehicle.setLicensePlate(tempArr[7]);
        
        deliveryPerson.setDeliveryVehicle(vehicle);
    }
    private void setPhone(DeliveryPerson deliveryPerson, String[] tempArr){
        deliveryPerson.getPNM().addPhoneNumber(tempArr[1]);
    }
    
    public void saveDeliveryPerson(DeliveryPerson deliveryPerson){
        int id = deliveryPerson.getID();
        String fileName = "txtDataFiles/deliveryPersonFiles/dp" + id + ".txt";
        
        try{
            File file = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            
            bw.write(writeDeliveryPerson(deliveryPerson));
            
            if(deliveryPerson.getDeliveryVehicle() == null)
                bw.write("~v,,,,,,,,\n");
            else{
                bw.write(writeVehicle(deliveryPerson.getDeliveryVehicle()));
                
            }
            
            if(deliveryPerson.getPNM().getPhoneNumbers().isEmpty())
                bw.write("~ph,,\n");
            else{
                for(String phone: deliveryPerson.getPNM().getPhoneNumbers()){
                    bw.write("~ph," + phone + ",\n");
                }
            }
            
            bw.close();
        }
        catch(IOException e){
            System.out.println(e);    
        }    
    }
    
    private String writeDeliveryPerson(DeliveryPerson deliveryPerson){
        return deliveryPerson.getName() + "," + deliveryPerson.getID() + "," + 
                deliveryPerson.getEmail() + "," + deliveryPerson.getPassword() 
                + ",\n";
    }
    
    private String writeVehicle(Vehicle vehicle){
        return "~v," + vehicle.getVehicleID() + "," + vehicle.getYear() + 
                "," + vehicle.getMake() + "," + vehicle.getModel()+ "," + 
                vehicle.getColor()+ "," + vehicle.getBodyStyle() + "," +
                vehicle.getBodyStyle() + ",\n";
    }
}
