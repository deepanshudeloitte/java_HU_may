package selectionSort;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class selectionSorting {
    private static final Logger logger = Logger.getLogger(selectionSorting.class.getName());

    public static void selectionSort(String[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            String temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.INFO); // Set logger level to INFO

        String[] arr = {"banana", "apple", "orange", "grape"};

        logger.log(Level.INFO, "Before sorting:");
        logger.log(Level.INFO, Arrays.toString(arr));

        selectionSort(arr);

        logger.log(Level.INFO, "After sorting:");
        logger.log(Level.INFO, Arrays.toString(arr));
    }
}
