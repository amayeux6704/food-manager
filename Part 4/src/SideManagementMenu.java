import java.util.Scanner;

public class SideManagementMenu {
    private Menu menu;
    private Scanner scanner;

    public SideManagementMenu(Menu menu, Scanner scanner){
        this.menu = menu;
        this.scanner = scanner;
    }

    public void showMenu(){
        while (true){
            System.out.println("\n--- Side Management Menu ---");
            System.out.println("1. Add side");
            System.out.println("2. Remove side");
            System.out.println("3. Update side name");
            System.out.println("4. Manage side Recipe");
            System.out.println("5. View side List");
            System.out.println("6. Return to menu management");
            System.out.print("Enter your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch(selection){
                case 1:
                    System.out.print("Enter side name: ");
                    String name = scanner.nextLine();
                    menu.addSide(name);
                    break;
                case 2:
                    System.out.print("Enter name of side to remove: ");
                    String aName = scanner.nextLine();
                    menu.removeSide(aName);
                    break;
                case 3: 
                    System.out.print("Enter the side you would like to updates name: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    menu.updateSide(oldName, newName);
                    break;
                case 4:
                    System.out.print("Enter the sides name that you want to edit the recipe of: ");
                    String sideName = scanner.nextLine();
                    Side side = menu.getSidesManager().findSide(sideName);               
                    new IngredientManagementMenu(side.getRecipe(), scanner).showMenu();
                    break;
                case 5:
                    menu.SideDisplay();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }
}
