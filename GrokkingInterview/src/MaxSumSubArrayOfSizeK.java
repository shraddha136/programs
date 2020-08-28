public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSum = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (k < end - start + 1) {
                sum -= arr[start++];
            }
            maxSum = Math.max(maxSum, sum);
            end++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}
