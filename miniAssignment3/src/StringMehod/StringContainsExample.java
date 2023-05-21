package StringMehod;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringContainsExample {
    private static final Logger logger = Logger.getLogger(StringContainsExample.class.getName());

    public static boolean contains(String str, String substring) {
        if (substring.isEmpty()) {
            // An empty substring is always considered to be present in the string
            return true;
        }

        int strLength = str.length();
        int subLength = substring.length();

        for (int i = 0; i <= strLength - subLength; i++) {
            boolean found = true;

            for (int j = 0; j < subLength; j++) {
                if (str.charAt(i + j) != substring.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                logger.log(Level.INFO, "Substring '" + substring + "' found at index " + i);
                return true;
            }
        }

        logger.log(Level.INFO, "Substring '" + substring + "' not found in the string.");
        return false;
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.OFF); // Turn off logging from other loggers

        String str = "Hello, world!";
        String substring1 = "world";
        String substring2 = "foo";

        boolean containsSubstring1 = contains(str, substring1);
        boolean containsSubstring2 = contains(str, substring2);

        logger.log(Level.INFO, "Contains substring '" + substring1 + "': " + containsSubstring1);
        logger.log(Level.INFO, "Contains substring '" + substring2 + "': " + containsSubstring2);
    }
}
