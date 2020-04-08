import java.util.Arrays;

public class MoveZeros {
    static void moveZerosToLeft(int[] nums) {
        int i = nums.length - 1;
        int j = nums.length - 1;
        while (j >= 0) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i--;
            }
                j--;
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));

        moveZerosToLeft(v);

        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }
}
