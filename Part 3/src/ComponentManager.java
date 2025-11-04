import java.util.ArrayList;

public class ComponentManager {

    private ArrayList<String> components;

    public ComponentManager(){
        this.components = new ArrayList<>();
    }

    public ArrayList<String> getComponents(){
        return components;
    }

    public void addComponent(String component){
        this.components.add(component);
    }

    public void removeComponent(String component){
        this.components.remove(component);
    }

    public void updateComponent(String oldComponent, String newComponent){
        for (String component : this.components) {
            if(component.equals(oldComponent)){
                this.components.remove(oldComponent);
                this.components.add(newComponent);
                System.out.println("The component has been updated.");
                break;
            } 
        }
    }
}
