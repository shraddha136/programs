class MaximumSubarray {
    public int maxSubArray(int[] nums) {
//        int maxSum = 0;
//        for(int i = 0;i<nums.length;i++){
//            int sum = nums[i];
//            for(int j = i + 1;j<nums.length;j++){
//                sum += nums[j];
//                maxSum = Math.max(maxSum,sum);
//            }
//        }
//        return maxSum; O(n^2)

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0)
                sum = num;
            else
                sum += num;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
