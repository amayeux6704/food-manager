import java.util.ArrayList;

public class PhoneNumberManager {

    private ArrayList<String> phoneNumbers;

    public PhoneNumberManager(){
        this.phoneNumbers = new ArrayList<>();
    }

    public void addPhoneNumber(String phoneNumber){
        this.phoneNumbers.add(phoneNumber);
    }

    public void updatePhoneNumber(String oldPhoneNumber, String newPhoneNumber){

    }

    public void removePhoneNumber(String phoneNumber){
        this.phoneNumbers.remove(phoneNumber);
    }
}
