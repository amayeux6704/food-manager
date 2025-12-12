import java.io.*;

/**
 * This class handles loading the data upon startup for the menu, menu recipes,
 * restaurant, inventory, and cost calculation objects to be used throughout
 * the system.
 * 
 * @author Alexander
 */
public class DataLoader {

    public Menu loadMenu(){
        Menu menu = new Menu();
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/dishData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 3){
                    String name = txtData[0];
                    double price = Double.parseDouble(txtData[2]);
                    menu.addDish(name, price);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/sideData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 1){
                    String name = txtData[0];
                    menu.addSide(name);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        loadRecipes(menu);
        return menu;
    }
    
    private void loadRecipes(Menu menu){
        
        for(Dish dish: menu.getDishManager().getDishes()){
            try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/" + dish.getName() + "RecipeData.txt"))){
                String data;
                while ((data = reader.readLine()) != null){
                    String[] txtData = data.split(",");
                    if (txtData.length == 2){
                        String iName = txtData[0];
                        int iQuantity = Integer.parseInt(txtData[1]);
                        dish.getRecipe().addIngredient(iName, iQuantity);
                    }
                }
            }   
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
        for(Side side: menu.getSidesManager().getSides()){
            try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/" + side.getName() + "SideRecipeData.txt"))){
                String data;
                while ((data = reader.readLine()) != null){
                    String[] txtData = data.split(",");
                    if (txtData.length == 2){
                        String iName = txtData[0];
                        int iQuantity = Integer.parseInt(txtData[1]);
                        side.getRecipe().addIngredient(iName, iQuantity);
                    }
                }
            }   
            catch (Exception e){
            e.printStackTrace();
            }
        }
    }
    
    public Restaurant loadRestaurant(){
        Restaurant restaurant = new Restaurant("");
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/restaurantNameData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 1){
                    String name = txtData[0];
                    restaurant.setName(name);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/locationData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 1){
                    String location = txtData[0];
                    restaurant.addLocation(location);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/openHourData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 1){
                    String hours = txtData[0];
                    restaurant.setOpenHours(hours);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/phoneNumberData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 1){
                    String nP = txtData[0];
                    restaurant.addPhoneNumber(nP);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/emailData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 1){
                    String nE = txtData[0];
                    restaurant.addEmail(nE);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return restaurant;
    }
    
    public Inventory loadInventory(){
        Inventory inventory = new Inventory();
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/inventoryData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 2){
                    String name = txtData[0];
                    int quantity = Integer.parseInt(txtData[1]);
                    inventory.addItem(name, quantity);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return inventory;
    }
    
    public CostCalculation loadCostCalculation(){
        CostCalculation costCalculation = new CostCalculation();
        try (BufferedReader reader = new BufferedReader(new FileReader("txtDataFiles/taxData.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                String[] txtData = data.split(",");
                if (txtData.length == 1){
                    double rate = Double.parseDouble(txtData[0]);
                    costCalculation.setTaxRate(rate);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return costCalculation;
    }
}
