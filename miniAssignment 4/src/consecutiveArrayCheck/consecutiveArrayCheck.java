package consecutiveArrayCheck;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consecutiveArrayCheck {
    private static final Logger logger = Logger.getLogger(consecutiveArrayCheck.class.getName());

    public static boolean areElementsConsecutive(int[] array) {
        // Sort the array in ascending order
        Arrays.sort(array);

        // Check if the elements are consecutive
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1] + 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.INFO); // Set logger level to INFO

        int[] array1 = {5, 3, 4, 1, 2};
        logger.log(Level.INFO, "Input: " + arrayToString(array1));
        logger.log(Level.INFO, "Output: " + areElementsConsecutive(array1));

//        int[] array2 = {47, 43, 45, 44, 46};
//        logger.log(Level.INFO, "Input: " + arrayToString(array2));
//        logger.log(Level.INFO, "Output: " + areElementsConsecutive(array2));
//
//        int[] array3 = {6, 7, 5, 6};
//        logger.log(Level.INFO, "Input: " + arrayToString(array3));
//        logger.log(Level.INFO, "Output: " + areElementsConsecutive(array3));
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
