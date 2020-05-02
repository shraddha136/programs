import java.util.Arrays;
import java.util.HashMap;

public class ZeroSumSubarray {
    public int[] zeroSum(int[] arr) {
//        int minLength = Integer.MAX_VALUE;
//        for(int i = 0;i<nums.length;i++){
//            int sum = nums[i];
//            for(int j = i+1;j<nums.length;j++){
//                sum += nums[j];
//                if(sum == 0){
//                    minLength = Math.min(minLength,j-i+1);
//                    break;
//                }
//            }
//        }
//        return minLength > 0 && minLength != Integer.MAX_VALUE;
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();

        int sum = 0;
        for (int i = 0; i <= arr.length; i++) {
            Integer oldIndex = sums.get(sum);
            if (oldIndex == null && i == arr.length) {
                return null;
            } else if (oldIndex == null) {
                sums.put(sum, i);
                sum += arr[i];
            } else {
                return Arrays.copyOfRange(arr, oldIndex, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -5, 1, 2, -1};
        System.out.println(Arrays.toString(new ZeroSumSubarray().zeroSum(nums)));
    }
}
