import java.util.Scanner;

public class CostCalculationMenu {
    private Scanner scanner;
    private CostCalculation costCalculation;

    public CostCalculationMenu(CostCalculation costCalculation, Scanner scanner){
        this.scanner = scanner;
        this.costCalculation = costCalculation;
    }
    public void showMenu(){
        while (true){
            System.out.println("\n--- Cost Management Menu ---");
            System.out.println("1. Set tax rate");
            System.out.println("2. View tax rate");
            System.out.println("3. Return");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter desired tax rate: ");
                    double tax  = scanner.nextDouble();
                    scanner.nextLine();
                    costCalculation.setTaxRate(tax);
                    break;
                case 2:
                    costCalculation.displayTaxRate();
                    break;
                case 3: 
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
