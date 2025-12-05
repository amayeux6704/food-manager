/** Manages the restaurant information
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class Restaurant {

    private String name;
    private LocationManager locationManager;
    private EmailManager emailManager;
    private PhoneNumberManager phoneNumberManager;
    private OpenHourManager openHourManager;

    public Restaurant(String name){
        this.name = name;
        this.locationManager = new LocationManager();
        this.emailManager = new EmailManager();
        this.phoneNumberManager = new PhoneNumberManager();
        this.openHourManager = new OpenHourManager();
    }

/**
 * Sets the name of the restaurant
 * @param name A string representing the restaurants name
 */
    public void setName(String name){
        this.name = name;
        System.out.println("Updated restaurant name to " + name);
    }

/**
 * Gets the restaurants name
 * @return The restaurants name
 */
    public String getName(){
        return name;
    }

/**
 * Adds a location to the restaurants locations
 * @param location A string representing a restaurant location
 */
    public void addLocation(String location){
        locationManager.addLocation(location);
    }

/**
 * Updates a restaurant location
 * @param oldLocation A string representing a old restaurant location
 * @param newLocation A string representing a new restaurant location
 */
    public void updateLocation(String oldLocation, String newLocation){
        locationManager.updateLocation(oldLocation, newLocation);
    }

/**
 * Removes a restaurant location
 * @param location A string representing a restaurant location
 */
    public void removeLocation(String location){
        locationManager.removeLocation(location);
    }

/**
 * Gets the set of restaurant locations
 * @return The set of restaurant location
 */
    public Set<String> getLocations(){
        return locationManager.getLocations();
    }

/**
 * Adds a phone number to the restaurants phone numbers
 * @param phoneNumber A string representing a restaurant phone number
 */
    public void addPhoneNumber(String phoneNumber){
        phoneNumberManager.addPhoneNumber(phoneNumber);
    }

/**
 * Updates a restaurant phone number
 * @param oldPhoneNumber A string representing a old restaurant phone number
 * @param newPhoneNumber A string representing a new restaurant phone number
 */
    public void updatePhoneNumber(String oldPhoneNumber, String newPhoneNumber){
        phoneNumberManager.updatePhoneNumber(oldPhoneNumber, newPhoneNumber);
    }

/**
 * Removes a phone number from the restaurants phone numbers
 * @param phoneNumber A string representing a restaurant phone number
 */
    public void removePhoneNumber(String phoneNumber){
        phoneNumberManager.removePhoneNumber(phoneNumber);
    }

/**
 * Gets the set of restaurant phone numbers
 * @return The set of restaurant phone numbers
 */
    public Set<String> getPhoneNumbers(){
        return phoneNumberManager.getPhoneNumbers();
    }

/**
 * Adds a email to the restaurant emails
 * @param email A string representing a restaurant email
 */
    public void addEmail(String email){
        emailManager.addEmail(email);
    }

/**
 * Updates a restaurant email
 * @param oldEmail A string representing a old restaurant email
 * @param newEmail A string representing a new restaurant email
 */
    public void updateEmail(String oldEmail, String newEmail){
        emailManager.updateEmail(oldEmail, newEmail);
    }

/**
 * Removes a restaurant email from the restaurant emails
 * @param email A string representing a restaurant email
 */
    public void removeEmail(String email){
        emailManager.removeEmail(email);
    }

/**
 * Gets the set of restaurant emails
 * @return The set of restaurant emails
 */
    public Set<String> getEmails(){
        return emailManager.getEmails();
    }

/**
 * Sets the restaurants open hours
 * @param openHours A string representing the restaurant open hours
 */
    public void setOpenHours(String openHours) {
        openHourManager.setOpenHours(openHours);
    }

/**
 * Gets the restaurants open hours
 * @return The restaurants open hours
 */
    public String getOpenHours(){
        return openHourManager.getOpenHours();
    }
}
