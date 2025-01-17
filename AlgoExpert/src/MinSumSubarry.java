public class MinSumSubarry {
    public static int minSubArrayLen(int s, int[] nums) {
        int j = 0;
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {
                minSize = Math.min(minSize, i - j + 1);
                sum -= nums[j++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
