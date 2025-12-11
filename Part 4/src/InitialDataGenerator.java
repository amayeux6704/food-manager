/**
 * This class generates initial dummy data for the program.
 * @author Alexander
 */
public class InitialDataGenerator {
    
    private CustomerManager cm;
    private DeliveryPersonManager dpm;
    private OrderManager gom;
    private Menu menu;
    private Restaurant restaurant;
    private Inventory inventory;
    private CostCalculation costCalculation;
    
    public InitialDataGenerator(CustomerManager cm, DeliveryPersonManager dpm, OrderManager gom, 
            Menu menu, Restaurant restaurant, Inventory inventory, CostCalculation costCalculation){
        this.cm = cm;
        this.dpm = dpm;
        this.gom = gom;
        this.menu = menu;
        this.restaurant = restaurant;
        this.inventory = inventory;
        this.costCalculation = costCalculation;
    }
    
    private void initializeCostCalculation(){
        float taxRate = 0.04875f;
        costCalculation.setTaxRate(taxRate);
    }
    
    public void generateDummyData(){
        System.out.println("Initializing Data...");
        initializeCostCalculation();
        generateDummyMenu();
        generateDummyInventory();
        generateDummyRestaurant();
        generateDummyCustomers();
        generateDummyDeliveryPeople();
        System.out.println("");
    }

    private void generateDummyInventory(){   
        inventory.addOrUpdateItem("tomato", 100);
        inventory.addOrUpdateItem("cheese", 1000);
        inventory.addOrUpdateItem("dough", 75);
        inventory.addOrUpdateItem("noodles", 50);
        inventory.addOrUpdateItem("patties", 125);
        inventory.addOrUpdateItem("bun", 250);
        inventory.addOrUpdateItem("potato", 200);
    }

    private void generateDummyMenu(){
        menu.addDish("pizza", 9.99);
        
        RecipeManager pizzaRecipe = new RecipeManager();
        pizzaRecipe.addIngredient("tomato", 5);
        pizzaRecipe.addIngredient("cheese", 5);
        pizzaRecipe.addIngredient("dough", 2);
        
        menu.addDishRecipe(1, pizzaRecipe);
        
        menu.addDish("burger", 5.99);
        
        RecipeManager burgerRecipe = new RecipeManager();
        burgerRecipe.addIngredient("patties", 1);
        burgerRecipe.addIngredient("bun", 2);
        
        menu.addDishRecipe(2, burgerRecipe);
        
        menu.addDish("pasta", 7.99);
        
        RecipeManager pastaRecipe = new RecipeManager();
        pastaRecipe.addIngredient("noodles", 2);
        pastaRecipe.addIngredient("tomato", 5);
        
        menu.addDishRecipe(3, pastaRecipe);
        
        menu.addSide("french fries");
        
        RecipeManager friesRecipe = new RecipeManager();
        friesRecipe.addIngredient("potato", 5);
        
        menu.addSideRecipe(friesRecipe, "french fries");
        
        menu.addSide("breadsticks");
        
        RecipeManager breadsticksRecipe = new RecipeManager();
        breadsticksRecipe.addIngredient("dough", 1);
        
        menu.addSideRecipe(breadsticksRecipe, "breadsticks");
    }

    private void generateDummyRestaurant(){
        restaurant.setName("Template Name");

        restaurant.addLocation("ABC Street");
        restaurant.addLocation("123 Avenue");

        restaurant.setOpenHours("10AM-7PM");

        restaurant.addPhoneNumber("123-456-7890");
        restaurant.addPhoneNumber("098-765-4321");

        restaurant.addEmail("yahoo@templatename.com");
        restaurant.addEmail("hamee@templatename.com");
    }
    
    private void generateDummyCustomers(){
        LoadSaveCustomer lsc = new LoadSaveCustomer();
        IDGenerator idGen = new IDGenerator();
        
        int id1 = idGen.generateId(cm, false);
        
        //Customer c1 = new Customer("John Doe", id1, false);
//        c1.setEmail("jdoe123@johndoe.com");
//        c1.setPassword("Password1");
//        
//        String c1Payment = "MasterCard";
//        
//        c1.getPayment().addPayMethod(c1Payment);
//        c1.getPayment().setCurrentPayMethod(c1Payment);
//        
//        int addrId1 = idGen.generateId(c1.getAddressManager());
//        
//        Address address1 = new Address(c1, addrId1);
//        address1.setLine1("123 Address ln.");
//        address1.setLine2("");
//        address1.setCity("Addressia");
//        address1.setState("ST");
//        address1.setZipCode("12345");
//        
//        c1.getAddressManager().addAddress(address1);
//        c1.getAddressManager().setPrimaryAddress(addrId1);

        Customer c1 = lsc.LoadCustomer(id1);
        
        cm.addCustomer(c1);
        
        OrderPlacer op = new OrderPlacer(c1, gom, menu, costCalculation, inventory);
        op.initializeOrder(menu);
        op.addDish(1, 3);
        op.calculateCost();
        op.setAddress(c1.getAddressManager().getPrimaryAddressID());
        op.setPayment(c1.getPayment().getCurrentPayMethod());
        op.placeOrder();
        
        
        int id2 = idGen.generateId(cm, false);
        
//        Customer c2 = new Customer("Mary Sue", id2, false);
//        c2.setEmail("ms567@yahoo.com");
//        c2.setPassword("Password2");
//        
//        String c2Payment = "Visa";
//        
//        c2.getPayment().addPayMethod(c2Payment);
//        c2.getPayment().setCurrentPayMethod(c2Payment);
//        
//        int addrId2 = idGen.generateId(c2.getAddressManager());
//        
//        Address address2 = new Address(c2, addrId2);
//        address2.setLine1("4567 Location st.");
//        address2.setLine2("");
//        address2.setCity("Cityville");
//        address2.setState("EX");
//        address2.setZipCode("56789");
//        
//        c2.getAddressManager().addAddress(address2);
//        c2.getAddressManager().setPrimaryAddress(addrId2);

        Customer c2 = lsc.LoadCustomer(id2);

        cm.addCustomer(c2);
    }
    
    private void generateDummyDeliveryPeople(){
        LoadSaveDeliveryPerson lsdp = new LoadSaveDeliveryPerson();
        IDGenerator idGen = new IDGenerator();
        
        int id1 = idGen.generateId(dpm);
        
//        DeliveryPerson dp1 = new DeliveryPerson("John Smith", id1);
//        dp1.setEmail("jsmith678@gmail.com");
//        dp1.setPassword("passwordJS");
//        
//        Vehicle vehicle1 = new Vehicle(dp1, dp1.getID());
//        vehicle1.setYear((short)2018);
//        vehicle1.setMake("Toyota");
//        vehicle1.setModel("Prius");
//        vehicle1.setColor("White");
//        vehicle1.setBodyStyle("Hatchback");
//        vehicle1.setLicensePlate("ABC123");
//        
//        dp1.setDeliveryVehicle(vehicle1);
//        
        DeliveryPerson dp1 = lsdp.LoadDeliveryPerson(id1);
        
        dpm.addDeliveryPerson(dp1);
        
        int id2 = idGen.generateId(dpm);
        
//        DeliveryPerson dp2 = new DeliveryPerson("Bob Robertson", id2);
//        dp2.setEmail("bobrob@gmail.com");
//        dp2.setPassword("passwordBR");
//        
//        Vehicle vehicle2 = new Vehicle(dp2, dp2.getID());
//        vehicle2.setYear((short)2010);
//        vehicle2.setMake("Ford");
//        vehicle2.setModel("Focus");
//        vehicle2.setColor("Blue");
//        vehicle2.setBodyStyle("Sedan");
//        vehicle2.setLicensePlate("DEF456");
//        
//        dp2.setDeliveryVehicle(vehicle2);
        DeliveryPerson dp2 = lsdp.LoadDeliveryPerson(id2);

        dpm.addDeliveryPerson(dp2);
    }
}
