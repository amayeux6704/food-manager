
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexander
 */
class EmployeeSettingsManager {
    private DeliveryPersonManager deliveryPersonManager;
    
    public EmployeeSettingsManager(DeliveryPersonManager deliveryPersonManager){
        this.deliveryPersonManager = deliveryPersonManager;
    }
    
    public void showEmployeeInfo(int id){
        DeliveryPerson deliveryPerson = deliveryPersonManager.searchDeliveryPerson(id);
        System.out.println(deliveryPerson);
    }
    
    public void updateName(int id){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter your updated name: ");
        
        String newName = input.nextLine();
        
        DeliveryPerson deliveryPerson = deliveryPersonManager.searchDeliveryPerson(id);
        deliveryPerson.setName(newName);
        
        System.out.println("Your name has been successfully updated!\n");
    }
    
    public void updateEmail(int id){
        Scanner input = new Scanner(System.in);
        char choice;
        DeliveryPerson deliveryPerson = deliveryPersonManager.searchDeliveryPerson(id);
        
        System.out.println("Current email address: " + deliveryPerson.getEmail());
        System.out.print("Are you sure you want to change this email address? y/n: ");
        
        choice = input.nextLine().charAt(0);
        
        if(Character.toLowerCase(choice) == 'y'){
            String newEmail;
            System.out.print("Please enter your updated email address: ");
            newEmail = input.nextLine();
            
            deliveryPerson.setEmail(newEmail);
            System.out.println("Your email address has been successfully changed!\n");
        }
        else{
            System.out.println("Operation cancelled.\n");
        }
    }
    
    public void updatePassword(int id){
        Scanner input = new Scanner(System.in);
        DeliveryPerson deliveryPerson = deliveryPersonManager.searchDeliveryPerson(id);
        
        System.out.print("Please enter your current password: ");
        
        String oldPassword = input.nextLine();
        
        if(deliveryPerson.getPassword().equals(oldPassword)){
            System.out.print("Please enter your new password: ");
            String newPassword = input.nextLine();
            
            System.out.print("Please re-enter your new password: ");
            String newPassword1 = input.nextLine();
            
            if(newPassword.equals(newPassword1)){
                deliveryPerson.setPassword(newPassword);
                System.out.println("Your password has been successfully changed!\n");
            }
            else{
                System.out.println("The two passwords do not match.\n");
            }
        }
        else{
            System.out.println("Incorrect password.\n");
        }
    }
    
    public void removeEmployee(int id){
        Scanner input = new Scanner(System.in);
        
        char choice;
        
        System.out.print("Are you sure you want to delete your account?\n" +
                           "This operation cannot be undone. y/n: ");
        
        choice = input.nextLine().charAt(0);
        
        if(choice == 'y'){
            deliveryPersonManager.removeDeliveryPerson(id);
            
            System.out.println("Your account has been successfully deleted.\n"+
                               "Now returning to the customer entry menu...\n");
        }
        else{
            System.out.println("Operation cancelled.\n");
        }
    }
}
