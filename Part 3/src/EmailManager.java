import java.util.HashSet;
import java.util.Set;

public class EmailManager {

    private Set<String> emails;

    public EmailManager(){
        this.emails = new HashSet<>();
    }

    public void addEmail(String email){
        this.emails.add(email.toLowerCase());
    }

    public void updateEmail(String newEmail, String oldEmail){
        if(this.emails.contains(oldEmail.toLowerCase())){
            this.emails.remove(oldEmail.toLowerCase());
            this.emails.add(newEmail.toLowerCase());
        } else {
            System.out.println("The email address could not be found. Update failed.");
        }
    }

    public void removeEmail(String email){
        if(this.emails.contains(email.toLowerCase())){
            this.emails.remove(email.toLowerCase());
        } else {
            System.out.println("The email address could not be found for removal.");
        }
    }

    public Set<String> getEmails(){
        return new HashSet<>(emails);
    }
}
