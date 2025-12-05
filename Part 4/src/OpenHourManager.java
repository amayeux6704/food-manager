/** Manages open hours
 * @author Brendan Casey
*/
public class OpenHourManager {

    private String openHours;

    public OpenHourManager(){
        this.openHours = "";
    }

/**
 * Sets the open hours
 * @param openHours A string representing the open hours
 */
    public void setOpenHours(String openHours){
        this.openHours = openHours;
    }

/**
 * Gets the open hours
 * @return The open hours
 */
    public String getOpenHours(){
        return openHours;
    }
}
