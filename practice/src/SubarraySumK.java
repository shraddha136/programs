public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int sum = 0;
        int j = 0;
        int count = 0;
        while (i < nums.length) {
            sum += nums[i];

            while (sum >= k) {
                if (sum == k)
                    count++;
                sum -= nums[j++];
            }

            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5,1};
        System.out.println(new SubarraySumK().subarraySum(nums, 1));
    }
}
