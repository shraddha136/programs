import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        for(int i = 1;i<dp.length;i++){
            if(dp[i]>dp[maxIndex]){
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        int maxVal = nums[maxIndex];
        int count = dp[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if(maxVal % nums[i]==0 && dp[i] == count){
                result.add(nums[i]);
                count--;
                maxVal = nums[i];
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4,8};
        System.out.println(new LargestDivisibleSet().largestDivisibleSubset(nums));
    }

}
