import java.util.ArrayList;

public class LocationManager {

    private ArrayList<String> locations;

    public LocationManager(){
        this.locations = new ArrayList<>();
    }

    public void addLocation(String location){
        this.locations.add(location);
    }

    public void updateLocation(String oldLocation, String newLocation){

    }

    public void removeLocation(String location){
        this.locations.remove(location);
    }
}
