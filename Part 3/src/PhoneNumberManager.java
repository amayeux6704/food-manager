import java.util.HashSet;
import java.util.Set;

public class PhoneNumberManager {

    private Set<String> phoneNumbers;

    public PhoneNumberManager(){
        this.phoneNumbers = new HashSet<>();
    }

    public void addPhoneNumber(String phoneNumber){
        this.phoneNumbers.add(phoneNumber);
    }

    public void updatePhoneNumber(String oldPhoneNumber, String newPhoneNumber){
        if(phoneNumbers.contains(oldPhoneNumber)){
            this.phoneNumbers.remove(oldPhoneNumber);
            this.phoneNumbers.add(newPhoneNumber);
            System.out.println("The phone number has been updated successfully.");
        } else {
            System.out.println("The given phone number could not be found. Update failed.");
        }
    }

    public void removePhoneNumber(String phoneNumber){
        if(phoneNumbers.contains(phoneNumber)){
            this.phoneNumbers.remove(phoneNumber);
            System.out.println(phoneNumber + " has been removed successfully.");
        } else {
            System.out.println("The given phone number could not be found for removal.");
        }
    }

    public Set<String> getPhoneNumbers(){
        return new HashSet<>(phoneNumbers);
    }
}
