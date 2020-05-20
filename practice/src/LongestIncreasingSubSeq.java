import java.util.Arrays;

public class LongestIncreasingSubSeq {
    public int lengthOfLIS(int[] nums) {
        return getLIS(nums,Integer.MIN_VALUE,0);
    }

    private int getLIS(int[] nums, int prev, int index) {
        if(index == nums.length)
            return 0;

        int taken = 0;
        if(prev<nums[index]){
            taken = 1 + getLIS(nums,nums[index],index+1);
        }
        int notTaken = getLIS(nums,prev,index+1);
        return Math.max(taken,notTaken);
    }

    public static void main(String[] args) {
        int[] ar = {10,9,2,5,3,4};
        System.out.println(new LongestIncreasingSubSeq().lengthOfLIS(ar));
        System.out.println(new LongestIncreasingSubSeq().lengthOfLISMemo(ar));
    }

    private int lengthOfLISMemo(int[] ar) {
        int[][] dp = new int[ar.length+1][ar.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return getLISMemo(ar,-1,0,dp);
    }

    private int getLISMemo(int[] ar, int prev, int index, int[][] dp) {
        if(index == ar.length)
            return 0;
        if(dp[prev+1][index]>=0)
            return dp[prev+1][index];

        int taken = 0;
        if(prev < 0 || ar[prev]<ar[index]){
            taken = 1 + getLISMemo(ar,index,index+1,dp);
        }
        int notTaken = getLISMemo(ar,prev,index+1,dp);
        dp[prev+1][index] = Math.max(taken,notTaken);
        return dp[prev+1][index];
    }
}
