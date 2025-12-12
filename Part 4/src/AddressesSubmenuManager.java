
import java.util.Scanner;

/**
 * This class manages all of the methods and functionality of the addresses
 * submenu.
 * @author Alexander
 */
public class AddressesSubmenuManager {
    
    private Customer customer;
    private AddressManager am;
    
    public AddressesSubmenuManager(Customer customer){
        this.customer = customer;
        am = customer.getAddressManager();
    }
    
    public void showAllAddresses(){
        if(am.hasAddresses()){am.showAddresses();}
    }
    
    public void changePrimary(){
        if(am.hasAddresses()){
            Scanner input = new Scanner(System.in);
        
            int id;
        
            System.out.print("Please enter the ID of the address you want to set to your primary: ");
        
            id = input.nextInt();
        
            setPrimary(id); 
        }
    }
    
    public void changePrimaryPrompt(int id){
        
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to set this address as your new primary?\n" +
                            "y/n: ");
        
        char choice = input.nextLine().charAt(0);
        
        if(choice == 'y'){
           setPrimary(id);
        }
    }
    
    public void setPrimary(int id){
        Scanner input = new Scanner(System.in);
        Address address = am.searchAddress(id);
        
        address.showAddressInformation();
        
        System.out.print("Is this the address you wish to change? y/n: ");
        
        char choice = input.nextLine().charAt(0);
        
        if(choice == 'y'){
            am.setPrimaryAddress(id);
        }
        else{
            System.out.println("Operation cancelled.\n");
        }
    }
    public void addNewAddress(){
        
        IDGenerator idGenerator = new IDGenerator();
        
        Scanner input = new Scanner(System.in);
        int id;
        
        id = idGenerator.generateId(am);
        
        Address address = new Address(customer, id);
        
        inputAddress(address);
        
        am.addAddress(address);
        if(am.getNumAddresses() > 1)
            changePrimaryPrompt(id);
        else
            am.setPrimaryAddress(id);
        
        System.out.println("New address has been added successfully!\n");
        
    }
    public void updateAddress(){
        if(am.hasAddresses()){
            Scanner input = new Scanner(System.in);
            int id;
        
            System.out.print("Please enter the ID of the address you wish to update: ");
            id = input.nextInt();
        
            Address address = am.searchAddress(id);
        
            if(address == null){
                System.out.println("That address does not exist.\n");
            }
            else{
                inputAddress(address);
                if(!address.isPrimary())
                    changePrimaryPrompt(id);
                
                System.out.println("Address had been updated successfully!\n");
            } 
        }
    }
    
    public void inputAddress(Address address){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter address line 1: ");
        address.setLine1(input.nextLine());
        System.out.print("Please enter address line 2 (Optional): ");
        
        String line2 = input.nextLine();
        if(line2.isEmpty()){address.setLine2("");}
        else{address.setLine2(line2);}
        
        System.out.print("Please enter the city: ");
        address.setCity(input.nextLine());
        System.out.print("Please enter the state: ");
        address.setState(input.nextLine());
        System.out.print("Please enter the zip code: ");
        address.setZipCode(input.nextLine());
    }
    
    public void removeAddress(){
        if(am.hasAddresses()){
            Scanner input = new Scanner(System.in);
            int id;
        
            System.out.print("Please enter the ID of the address you wish to remove: ");
            id = input.nextInt();
        
            am.deleteAddress(id);
            
        }
    }
}
