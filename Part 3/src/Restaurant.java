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

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addLocation(String location){
        locationManager.addLocation(location);
    }

    public void updateLocation(String oldLocation, String newLocation){
        locationManager.updateLocation(oldLocation, newLocation);
    }

    public void removeLocation(String location){
        locationManager.removeLocation(location);
    }

    public Set<String> getLocations(){
        return locationManager.getLocations();
    }

    public void addPhoneNumber(String phoneNumber){
        phoneNumberManager.addphoneNumber(phoneNumber);
    }

    public void updatePhoneNumber(String oldPhoneNumber, String newPhoneNumber){
        phoneNumberManager.updatephoneNumber(oldPhoneNumber, newPhoneNumber);
    }

    public void removePhoneNumber(String phoneNumber){
        phoneNumberManager.removephoneNumber(phoneNumber);
    }

    public Set<String> getPhoneNumbers(){
        return phoneNumberManager.getphoneNumbers();
    }

    public void addEmail(String email){
        emailManager.addEmail(email);
    }

    public void updateEmail(String oldEmail, String newEmail){
        emailManager.updateEmail(oldEmail, newEmail);
    }

    public void removeEmail(String email){
        emailManager.removeEmail(email);
    }

    public Set<String> getEmails(){
        return emailManager.getEmails();
    }

    public void setOpenHours(String openHours) {
        openHourManager.setOpenHours(openHours);
    }

    public String getOpenHours(){
        return openHourManager.getOpenHours();
    }
}
