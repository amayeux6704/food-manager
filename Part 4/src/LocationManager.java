import java.util.HashSet;
import java.util.Set;

public class LocationManager {

    private Set<String> locations;

    public LocationManager(){
        this.locations = new HashSet<>();
    }

    public void addLocation(String location){
        this.locations.add(location.toLowerCase());
    }

    public void updateLocation(String oldLocation, String newLocation){
        if(locations.contains(oldLocation.toLowerCase())){
            this.locations.remove(oldLocation.toLowerCase());
            this.locations.add(newLocation.toLowerCase());
            System.out.println("The location has been updated successfully.");
        } else {
            System.out.println("The given location could not be found. Update failed.");
        }
    }

    public void removeLocation(String location){
        if(locations.contains(location.toLowerCase())){
            this.locations.remove(location.toLowerCase());
            System.out.println(location + " has been removed successfully.");
        } else {
            System.out.println("The given location could not be found for removal.");
        }
    }

    public Set<String> getLocations(){
        return new HashSet<>(locations);
    }
}
