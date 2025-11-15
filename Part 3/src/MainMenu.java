
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexander
 */
public class MainMenu implements ProgramMenu{
    
    private CustomerManager cm;
    private DeliveryPersonManager dpm;
    private CustomerEntrySubmenu ces;
    private EmployeeEntrySubmenu ees;
    
    public MainMenu(CustomerManager cm, DeliveryPersonManager dpm, OrderManager gom, Menu menu){
        this.cm = cm;
        this.dpm = dpm;
        ces = new CustomerEntrySubmenu(cm, gom, menu);
        ees = new EmployeeEntrySubmenu(dpm, gom);
    }
    
    @Override
    public void showMenu(){
        byte choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Main Menu:\n"+
                               "______________________________________________\n"+
                               "1. Enter as Customer/Guest \n"+
                               "2. Enter as Employee\n" +
                               "3. Exit\n"+
                               "______________________________________________\n"+
                               "Please select your choice: ");
            
            choice = input.nextByte();
            
            System.out.println("");
            
            switch(choice){
                case 1:
                    ces.showMenu();
                    break;
                case 2:
                    ees.showMenu();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("That choice was invalid..."+
                                       "Please try again.");
                    break;
            }
        }
        while(choice != 3);
    }
}
