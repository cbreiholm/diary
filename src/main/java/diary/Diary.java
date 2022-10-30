package diary;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Diary {
    // here I create and initialize everything I need for the diary
    private static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat ("E dd-MM-yyyy HH:mm");
    static Date date = new Date();
    static Entry entry = new Entry();
    static ObjectMapper mapper = new ObjectMapper();
    static List<Entry> entries = new ArrayList();
    static List<Entry> entryList = new ArrayList();
    static Path path = Paths.get("src/main/resources/entries.json");

    /** This method is used to handle the users input
     * to the diary, as well as the date - and then
     * saves it into a JSON file
     *
     * @throws IOException On input error
     */
    static void userEntries() throws IOException {
        // checks if path to the json file exists
        if(path.toFile().exists()) {
            entries = List.of(mapper.readValue(path.toFile(), Entry[].class));
            entryList.addAll(entries);
        }
        // asks and sets the title
        System.out.println("Enter your title: ");
        String title = scanner.nextLine();
        entry.setTitle(title);
        // asks and sets the text
        System.out.println("Enter your text: ");
        String text = scanner.nextLine();
        entry.setText(text);
        // sets the current date
        entry.setDate(dateFormat.format(date));
        // adds the entries in entry into entryList
        entryList.add(entry);
        // prints the added dairy post
        System.out.println("-----------------");
        System.out.println("Your diary post: ");
        System.out.println("Date and Time: " + dateFormat.format(date));
        System.out.println("Title: " + title);
        System.out.println("Text: " + text);
        // writes the value from entryList to the JSON file
        mapper.writeValue(path.toFile(), entryList);
    }

    /** This method is used to print out the contents
     * of the diary
     *
     * @throws IOException On input error
     */
    static void readEntries() throws IOException {
        // try and catch in case the users choice is to search before creating a post
        try {
            //so that we can use a for each loop and go through
            //entries in the JSON file
            Entry[] fetchEntries;
            fetchEntries = mapper.readValue(path.toFile(), Entry[].class);

            // prints all entries in the json file with a for each loop
            for (Entry entries : fetchEntries) {
                System.out.println("\nTitle:  " + entries.getTitle());
                System.out.println("Text: " + entries.getText());
                System.out.println("Date: " + entries.getDate());
                System.out.println("--------------------------");
            }
        } catch (Exception E) {
            System.out.println("Before you can search for diary posts, you" +
                    " have to add one!");
            System.out.println("Please try again.");
        }
    }

    /** This method is used to print the home screen message
     *
     */
    public void printHomeScreen() {
        // prints the home screen
        System.out.println();
        System.out.println("Welcome to your personal virtual diary!");
        System.out.println("Today is: " + entry.currentDateAndTime());
        System.out.println();
    }
}