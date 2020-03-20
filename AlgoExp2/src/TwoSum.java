import java.util.Arrays;

public class TwoSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        if (array.length < 1)
            return new int[]{-1, -1};

        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int sum = array[i] + array[j];
            if (sum == targetSum)
                return new int[]{array[i], array[j]};
            if (sum < targetSum)
                i++;
            else
                j--;
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] array = {4, 6, 1};
//        int[] array = {3,5,-4,8,11,1,-1,6};
        System.out.println(Arrays.toString(twoNumberSum(array, 5)));
    }
}
