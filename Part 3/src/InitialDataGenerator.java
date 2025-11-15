/**
 *
 * @author Alexander
 */
public class InitialDataGenerator {
    
    private CustomerManager cm;
    private DeliveryPersonManager dpm;
    private OrderManager gom;
    private Menu menu;
    
    public InitialDataGenerator(CustomerManager cm, DeliveryPersonManager dpm, OrderManager gom, Menu menu){
        this.cm = cm;
        this.dpm = dpm;
        this.gom = gom;
        this.menu = menu;
    }
    
    public void generateDummyData(){
        generateDummyCustomers();
        generateDummyDeliveryPeople();
    }
    
    public void generateDummyCustomers(){
        
        IDGenerator idGen = new IDGenerator();
        
        int id1 = idGen.generateId(cm, false);
        
        Customer c1 = new Customer("John Doe", id1, false);
        c1.setEmail("jdoe123@johndoe.com");
        c1.setPassword("Password1");
        
        String c1Payment = "MasterCard";
        
        c1.addPayMethod(c1Payment);
        c1.setPrimaryPayment(c1Payment);
        
        int addrId1 = idGen.generateId(c1.getAddressManager());
        
        Address address1 = new Address(c1, addrId1);
        address1.setLine1("123 Address ln.");
        address1.setLine2("");
        address1.setCity("Addressia");
        address1.setState("ST");
        address1.setZipCode("12345");
        
        c1.getAddressManager().addAddress(address1);
        c1.getAddressManager().setPrimaryAddress(addrId1);
        
        cm.addCustomer(c1);
        
        int id2 = idGen.generateId(cm, false);
        
        Customer c2 = new Customer("Mary Sue", id2, false);
        c2.setEmail("ms567@yahoo.com");
        c2.setPassword("Password2");
        
        String c2Payment = "Visa";
        
        c2.addPayMethod(c2Payment);
        c2.setPrimaryPayment(c2Payment);
        
        int addrId2 = idGen.generateId(c2.getAddressManager());
        
        Address address2 = new Address(c2, addrId2);
        address2.setLine1("4567 Location st.");
        address2.setLine2("");
        address2.setCity("Cityville");
        address2.setState("EX");
        address2.setZipCode("56789");
        
        c2.getAddressManager().addAddress(address2);
        c2.getAddressManager().setPrimaryAddress(addrId2);
        
        cm.addCustomer(c2);
    }
    
    public void generateDummyDeliveryPeople(){
        IDGenerator idGen = new IDGenerator();
        
        int id1 = idGen.generateId(dpm);
        
        DeliveryPerson dp1 = new DeliveryPerson("John Smith", id1);
        dp1.setEmail("jsmith678@gmail.com");
        dp1.setPassword("passwordJS");
        
        Vehicle vehicle1 = new Vehicle(dp1, dp1.getID());
        vehicle1.setYear((short)2018);
        vehicle1.setMake("Toyota");
        vehicle1.setModel("Prius");
        vehicle1.setColor("White");
        vehicle1.setLicensePlate("ABC123");
        
        dp1.setDeliveryVehicle(vehicle1);
        
        dpm.addDeliveryPerson(dp1);
        
        int id2 = idGen.generateId(dpm);
        
        DeliveryPerson dp2 = new DeliveryPerson("Bob Robertson", id2);
        dp2.setEmail("bobrob@gmail.com");
        dp2.setPassword("passwordBR");
        
        Vehicle vehicle2 = new Vehicle(dp2, dp2.getID());
        vehicle2.setYear((short)2010);
        vehicle2.setMake("Ford");
        vehicle2.setModel("Focus");
        vehicle2.setColor("Blue");
        vehicle2.setLicensePlate("DEF456");
        
        dp2.setDeliveryVehicle(vehicle2);
        
        dpm.addDeliveryPerson(dp2);
    }
}
