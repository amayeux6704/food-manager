/** Manages the locations 
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class LocationManager {

    private Set<String> locations;

    public LocationManager(){
        this.locations = new HashSet<>();
    }

/**
 * Adds a location to the set of locations
 * @param location A string representing a location's address
 */
    public void addLocation(String location){
        this.locations.add(location.toLowerCase());
    }

/**
 * Updates a location
 * @param oldLocation A string representing an location's old address
 * @param newLocation A string representing a location's new address
 */
    public void updateLocation(String oldLocation, String newLocation){
        if(locations.contains(oldLocation.toLowerCase())){
            this.locations.remove(oldLocation.toLowerCase());
            this.locations.add(newLocation.toLowerCase());
            System.out.println("The location has been updated successfully.");
        } else {
            System.out.println("The given location could not be found. Update failed.");
        }
    }

/**
 * Removes a location from the set of locations
 * @param location A string representing a location's address
 */
    public void removeLocation(String location){
        if(locations.contains(location.toLowerCase())){
            this.locations.remove(location.toLowerCase());
            System.out.println(location + " has been removed successfully.");
        } else {
            System.out.println("The given location could not be found for removal.");
        }
    }

/**
 * Gets the set of locations
 * @return The set of locations
 */
    public Set<String> getLocations(){
        return new HashSet<>(locations);
    }
}
