import java.util.Scanner;

public class IngredientManagementMenu {
    private RecipeManager recipeManager;
    private Scanner scanner;
    
    public IngredientManagementMenu(RecipeManager recipeManager, Scanner scanner){
        this.recipeManager = recipeManager;
        this.scanner = scanner;
    }

    public void showMenu(){
        while (true){
            System.out.println("\n--- Ingredient Management Menu ---");
            System.out.println("1. Add ingredient");
            System.out.println("2. Remove ingredient");
            System.out.println("3. Update ingredient");
            System.out.println("4. View ingredients");
            System.out.println("5. Return to menu management");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter ingredient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    recipeManager.addIngredient(name, quantity);
                    break;
                case 2:
                    System.out.print("Enter ingredient to remove: ");
                    String aName = scanner.nextLine();
                    recipeManager.removeIngredient(aName);
                    break;
                case 3: 
                    System.out.print("Enter the ingredient you would like to updates name: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter the new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();
                    recipeManager.updateIngredient(oldName, newName, newQuantity);
                    break;
                case 4:
                    System.out.println(recipeManager);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
