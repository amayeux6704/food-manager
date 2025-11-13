
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexander
 */
public class EmployeeEntrySubmenu implements ProgramMenu{
    private DeliveryPersonManager dpm;
    private EmployeeSubmenu es;
    private AccountScreen as;
    
    public EmployeeEntrySubmenu(DeliveryPersonManager dpm){
        this.dpm = dpm;
        as = new AccountScreen();
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Employee Entry:\n"+
                               "______________________________________________\n"+
                               "1. Login\n"+
                               "2. Create new Profile\n"+
                               "3. Back to Main\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            DeliveryPerson deliveryPerson = null;
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    deliveryPerson = as.logIn(dpm);
                    break;
                case 2:
                    deliveryPerson = as.signUp(dpm);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
            if(deliveryPerson != null){
                es = new EmployeeSubmenu(dpm, deliveryPerson.getID());
                es.showMenu();
            }
        }
        while(choice != 3);
    }
}