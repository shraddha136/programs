class PartitionSet {

    public boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return false;

        return this.canPartitionRecursive(num, sum / 2, 0);
    }

    private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        // base check
        if (sum == 0)
            return true;

        if (num.length == 0 || currentIndex >= num.length)
            return false;

        // recursive call after choosing the number at the currentIndex
        // if the number at currentIndex exceeds the sum, we shouldn't process this
        if (num[currentIndex] <= sum) {
            if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
                return true;
        }

        // recursive call after excluding the number at the currentIndex
        return canPartitionRecursive(num, sum, currentIndex + 1);
    }


    public boolean canPartitionDp(int[] nums) {
        int total = 0;
        for (int i : nums)
            total += i;
        if (total % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[nums.length][total / 2 + 1];
        return canPartitionDPMeMo(nums, dp, 0, total / 2);
    }

    private boolean canPartitionDPMeMo(int[] nums, Boolean[][] dp, int index, int sum) {
        if (sum == 0)
            return true;
        if (index >= nums.length)
            return false;
        if (dp[index][sum] == null) {
            if (nums[index] <= sum) {
                if (canPartitionDPMeMo(nums, dp, index + 1, sum - nums[index])) {
                    dp[index][sum] = true;
                    return true;
                }
            }
            dp[index][sum] = canPartitionDPMeMo(nums, dp, index + 1, sum);
        }
        return dp[index][sum];
    }

    public boolean canPart(int[] nums) {
        int total = 0;
        for (int i : nums)
            total += i;
        if(total%2!=0)
            return false;
        total = total / 2;
        Boolean[][] dp = new Boolean[nums.length][total + 1];

        for(int i = 0;i<nums.length;i++)
            dp[i][0] = true;

        for(int i = 1;i<=total;i++)
            dp[0][i] = nums[0] == i;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = 1; sum <= total; sum++) {
                if (dp[i - 1][sum])
                    dp[i][sum] = dp[i - 1][sum];
                else if (sum >= nums[i])
                    dp[i][sum] = dp[i - 1][sum - nums[i]];
            }
        }
        return dp[nums.length - 1][total];
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPart(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPart(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPart(num));
    }
}
