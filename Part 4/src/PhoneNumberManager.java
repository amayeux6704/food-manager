/** Manages phone numbers
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class PhoneNumberManager {

    private Set<String> phoneNumbers;

    public PhoneNumberManager(){
        this.phoneNumbers = new HashSet<>();
    }

/**
 * Adds a phone number to the list of phone numbers
 * @param phoneNumber A string for representing a phone number
 */
    public void addPhoneNumber(String phoneNumber){
        this.phoneNumbers.add(phoneNumber);
    }

/**
 * Updates a phone number
 * @param oldPhoneNumber A string representing a old phone number
 * @param newPhoneNumber A string representing a new phone number
 */
    public void updatePhoneNumber(String oldPhoneNumber, String newPhoneNumber){
        if(phoneNumbers.contains(oldPhoneNumber)){
            this.phoneNumbers.remove(oldPhoneNumber);
            this.phoneNumbers.add(newPhoneNumber);
            System.out.println("The phone number has been updated successfully.");
        } else {
            System.out.println("The given phone number could not be found. Update failed.");
        }
    }

/**
 * Removes a phone number from the set of phone numbers
 * @param phoneNumber A string representing a phone number
 */
    public void removePhoneNumber(String phoneNumber){
        if(phoneNumbers.contains(phoneNumber)){
            this.phoneNumbers.remove(phoneNumber);
            System.out.println(phoneNumber + " has been removed successfully.");
        } else {
            System.out.println("The given phone number could not be found for removal.");
        }
    }

/**
 * Gets the set of phone numbers
 * @return The set of phone numbers
 */
    public Set<String> getPhoneNumbers(){
        return new HashSet<>(phoneNumbers);
    }
}
