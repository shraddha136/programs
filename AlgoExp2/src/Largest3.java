import java.util.Arrays;

public class Largest3 {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] largest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int value : array) {
            if (value >= largest[0]) {
                largest[2] = largest[1];
                largest[1] = largest[0];
                largest[0] = value;
            } else if (value <= largest[0] && value > largest[1]) {
                largest[2] = largest[1];
                largest[1] = value;
            } else if (value <= largest[1] && value > largest[2]) {
                largest[2] = value;
            }
        }
        Arrays.sort(largest);
        System.out.println(Arrays.toString(largest));
        return largest;
    }

    public static void main(String[] args) {
        int[] nums = {55, 43, 11, 3, -3, 10};
        System.out.println(Arrays.toString(findThreeLargestNumbers(nums)));
    }

}
