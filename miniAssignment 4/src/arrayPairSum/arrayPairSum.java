package arrayPairSum;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class arrayPairSum {
    private static final Logger logger = Logger.getLogger(arrayPairSum.class.getName());

    public static List<List<Integer>> findPairs(int[] nums, int targetSum) {
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];

                if (num1 + num2 == targetSum) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(num1);
                    pair.add(num2);
                    pairs.add(pair);
                }
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.INFO); // Set logger level to INFO

        int[] nums = {-40, -5, 1, 3, 6, 7, 8, 20};
        int targetSum = 15;

        logger.log(Level.INFO, "Input Array: ");
        logger.log(Level.INFO, arrayToString(nums));
        logger.log(Level.INFO, "Target Sum: " + targetSum);

        List<List<Integer>> pairs = findPairs(nums, targetSum);

        logger.log(Level.INFO, "The pairs whose sum is equal to " + targetSum + ":");
        for (List<Integer> pair : pairs) {
            logger.log(Level.INFO, pair.get(0) + " " + pair.get(1));
        }
    }

    private static String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
