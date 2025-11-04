public class Restaurant {

    private String name;

    public Restaurant(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getOpenHours(){
        return openHours;
    }

    public ArrayList<String> getLocations(){
        return locations;
    }

    public ArrayList<String> getPhoneNumbers(){
        return phoneNumbers;
    }

    public ArrayList<String> getEmails(){
        return emails;
    }
}
