public class Kadane {
    public int kadane(int[] nums){
        int i = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(i<nums.length){
            currSum += nums[i];
            if(currSum<nums[i]){
                currSum = nums[i];
            }
            maxSum = Math.max(maxSum,currSum);
            i++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,2,5,-11,6};
        System.out.println(new Kadane().kadane(nums));
    }
}
