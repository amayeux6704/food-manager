/** Manages emails
 * @author Brendan Casey
*/
import java.util.HashSet;
import java.util.Set;

public class EmailManager {

    private Set<String> emails;

    public EmailManager(){
        this.emails = new HashSet<>();
    }

/**
 * Adds a email to the set of emails
 * @param email A string representing a email address
 */
    public void addEmail(String email){
        this.emails.add(email.toLowerCase());
    }

/**
 * Updates the email address
 * @param newEmail A string representing the new email address
 * @param oldEmail A string representing the old email address
 */
    public void updateEmail(String newEmail, String oldEmail){
        if(this.emails.contains(oldEmail.toLowerCase())){
            this.emails.remove(oldEmail.toLowerCase());
            this.emails.add(newEmail.toLowerCase());
            System.out.println("The email has been updated successfully.");

        } else {
            System.out.println("The email address could not be found. Update failed.");
        }
    }

/**
 * Removes a email from the set of emails
 * @param email A string representing a email address
 */
    public void removeEmail(String email){
        if(this.emails.contains(email.toLowerCase())){
            this.emails.remove(email.toLowerCase());
            System.out.println(email + " has been removed successfully.");
        } else {
            System.out.println("The email address could not be found for removal.");
        }
    }

/**
 * Gets a email address
 * @return A email address
 */
    public Set<String> getEmails(){
        return new HashSet<>(emails);
    }
}
