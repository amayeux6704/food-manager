import java.util.ArrayList;

public class EmailManager {

    private ArrayList<String> emails;

    public EmailManager(){
        this.emails = new ArrayList<>();
    }

    public void addEmail(String email){
        this.emails.add(email);
    }

    public void updateEmail(String newEmail, String oldEmail){

    }

    public void removeEmail(String email){
        this.emails.remove(email);
    }
}
