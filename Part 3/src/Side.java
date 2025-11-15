public class Side {
    private String name;
    private RecipeManager recipe;

    public Side(String name){
        this.name = name.toLowerCase();
        this.recipe = new RecipeManager();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name.toLowerCase();
    }

    public RecipeManager getRecipe(){
        return recipe;
    }

    public void setRecipe(RecipeManager recipe){
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){ 
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Side side = (Side) obj;
        return name.equals(side.name);
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
