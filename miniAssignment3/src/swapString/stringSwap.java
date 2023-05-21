package swapString;

import java.util.logging.Level;
import java.util.logging.Logger;

public class stringSwap {
    private static final Logger logger = Logger.getLogger(stringSwap.class.getName());

    public static void swapStrings(String firstString, String secondString) {
        logger.log(Level.INFO, "Before swap:");
        logger.log(Level.INFO, "firstString: " + firstString);
        logger.log(Level.INFO, "secondString: " + secondString);

        // Append the second string to the first string
        firstString = firstString + secondString;

        // Extract the original second string from the updated first string
        secondString = firstString.substring(0, firstString.length() - secondString.length());

        // Extract the original first string from the updated first string
        firstString = firstString.substring(secondString.length());

        logger.log(Level.INFO, "After swap:");
        logger.log(Level.INFO, "firstString: " + firstString);
        logger.log(Level.INFO, "secondString: " + secondString);
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.OFF); // Turn off logging from other loggers

        String firstString = "Hi Java";
        String secondString = "Hello Python";

        swapStrings(firstString, secondString);
    }
}
