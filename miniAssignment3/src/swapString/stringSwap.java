package swapString;

import java.util.logging.Level;
import java.util.logging.Logger;

public class stringSwap {
    private static final Logger logger = Logger.getLogger(stringSwap.class.getName());

    public static void swapStrings(StringBuilder str1, StringBuilder str2) {
        logger.log(Level.INFO, "Before swap:");
        logger.log(Level.INFO, "First String: " + str1);
        logger.log(Level.INFO, "Second String: " + str2);

        str1.append(str2);
        str2 = new StringBuilder(str1.substring(0, str1.length() - str2.length()));
        str1 = new StringBuilder(str1.substring(str2.length()));

        logger.log(Level.INFO, "After swap:");
        logger.log(Level.INFO, "First String: " + str1);
        logger.log(Level.INFO, "Second String: " + str2);
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.INFO); // Set logger level to INFO

        StringBuilder firstString = new StringBuilder("Hi Java");
        StringBuilder secondString = new StringBuilder("Hello Python");

        swapStrings(firstString, secondString);
    }
}
