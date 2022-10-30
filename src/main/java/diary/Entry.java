package diary;

import java.text.SimpleDateFormat;
import java.util.Date;

/** Represents the users entry into the diary
 */
public class Entry {
    private String title;
    private String text;
    private String date;

    /** Gets the date
     * @return Returns a String representing the date
     */
    public String getDate() {
        return date;
    }

    /** Sets the date
     * @param date A String containing the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /** Gets the diary text
     * @return Returns a String representing the
     * dairy text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the diary text
     * @param text A String containing the dairy text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the diary title
     * @return Returns a String with the dairy title
     */
    public String getTitle() {
        return title;
    }

    /** Sets the diary title
     * @param title A string containing the dairy title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** Empty Entry constructor
     */
    public Entry() {
    }

    /** Current date and time
     * @return Returns the current date and time
     * in my chosen format
     */
    public static String currentDateAndTime() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat ("E dd-MM-yyyy HH:mm");
        return sf.format(date);
    }
}