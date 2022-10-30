package diary;

import java.io.IOException;
import java.util.Scanner;

/**
 * --Dairy--
 * The Diary program allows the user to write and save
 * titles, text and date. The program saves the users'
 * diary posts and saves them into a JSON file, as well
 * as printing the diary posts to the screen.
 *
 * @author  Carl Breiholm
 * @since   2022-10-30
 */

public class Journal {

    /** Main method that is used for taking the user
     * choices and calling the appropriate methods, with
     * the use of a while loop and switch cases
     *
     * @param args Unused
     * @throws IOException On input error
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // diary instance
        Diary diary = new Diary();
        String choice = "0";
        // main while loop
        while (!choice.equals("3")) {
            // printing the home screen
            diary.printHomeScreen();
            System.out.println("-----------------");
            System.out.println("Choose an action:");
            System.out.println("1 - Add an entry");
            System.out.println("2 - Search for entries");
            System.out.println("3 - End");
            choice = scanner.nextLine();
            System.out.println();
            // switch with 3 different choices
            switch (choice) {
                case "1":
                    Diary.userEntries();
                    break;
                case "2":
                    Diary.readEntries();
                    break;
                case "3":
                    System.out.println("Press any key to quit the program...");
                    break;
                default:
                    System.out.println("Error. Press any key to choose another action.");
                    break;
            }
        }
    }
}