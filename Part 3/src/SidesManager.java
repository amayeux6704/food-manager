import java.util.ArrayList;

public class SidesManager {

    private ArrayList<String> sides;

    public SidesManager(){
        this.sides = new ArrayList<>();
    }

    public ArrayList<String> getSides(){
        return sides;
    }

    public void addSide(String side){
        this.sides.add(side);
    }

    public void removeSide(String side){
        this.sides.remove(side);
    }

    public void updateSide(String oldSide, String newSide){
        for (String side : this.sides) {
            if(side.equals(oldSide)){
                this.sides.remove(oldSide);
                this.sides.add(newSide);
                System.out.println("The side has been updated.");
                break;
            } 
        }
    }
}
