package app;

import Chapter.*;
import java.util.Scanner;

/**
 * This is the enty point class of the JavaTutorial. this class request chapter
 * number in the format of chapter_section, and then pass it to the router
 * classes recursively.
 * 
 * @version 1.0
 * @author Chanth Miao
 */
public class StartUp {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to classwork display repo of group 1");
        System.out.print("Please enter number of task you want to launch(e.g 1_4 means chapter 1.4): ");
        Scanner getOpt = new Scanner(System.in);
        int x, y;
        String optString = "\n";
        while (!optString.toLowerCase().equals("q")) {
            if (getOpt.hasNext("\\d{1,2}_\\d{1,2}$")) {
                getOpt.useDelimiter("\\D");
                x = getOpt.nextInt();
                y = getOpt.nextInt();
                getOpt.nextLine();
                Router.choose(x, y);
                System.out.print("\nAnother input, or q to exit: ");
                getOpt.reset();
            } else {
                optString = getOpt.next();
                if (!optString.toLowerCase().equals("q")) {
                    System.out.println("Invalid input, string in format of \"chapter_section\" is needed.");
                    System.out.print("Try again: ");
                }
            }
        }

        getOpt.close();
        System.out.println("Bye!");
    }
}