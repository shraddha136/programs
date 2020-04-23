public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < nums.length) {
            sum += nums[i];
            if (sum > k)
                sum -= nums[j++];
            if (sum == k) {
                count++;
                sum -= nums[j++];
            }

            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySum().subarraySum(new int[]{1, 3, 4, 2, 3, 1, 1}, 7));
    }
}

