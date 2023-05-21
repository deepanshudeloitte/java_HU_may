package longestPrefix;

import java.util.logging.Level;
import java.util.logging.Logger;

public class longestCommonPrefix{
    private static final Logger logger = Logger.getLogger(longestCommonPrefix.class.getName());

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "No common prefix found";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.INFO); // Set logger level to INFO

        String[] arr = {"flower", "flow", "flight"};

        logger.log(Level.INFO, "Input array: ");
        logger.log(Level.INFO, String.join(", ", arr));

        String longestPrefix = longestCommonPrefix(arr);

        logger.log(Level.INFO, "Longest common prefix: " + longestPrefix);
    }
}
