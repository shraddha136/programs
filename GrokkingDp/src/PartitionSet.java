public class PartitionSet {
    static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];
        if (sum % 2 != 0)
            return false;
        Boolean[][] memo = new Boolean[num.length][sum/2 + 1];
        return canPartitionMemo(memo, num, sum / 2, 0);
//        return canPartitionRec(num, sum / 2, 0);
    }

    private static boolean canPartitionMemo(Boolean[][] memo, int[] num, int sum, int index) {
        if (sum == 0)
            return true;
        if (num.length == 0 || index >= num.length)
            return false;
        if(memo[index][sum]==null){
            if (num[index] <= sum) {
                if (canPartitionRec(num, sum - num[index], index + 1)){
                    memo[index][sum] =  true;
                    return true;
                }
            }
        }

        memo[index][sum] =  canPartitionRec(num, sum, index + 1);
        return memo[index][sum];
    }

    private static boolean canPartitionRec(int[] num, int sum, int index) {
        if (sum == 0)
            return true;
        if (num.length == 0 || index >= num.length)
            return false;
        if (num[index] <= sum) {
            if (canPartitionRec(num, sum - num[index], index + 1))
                return true;
        }
        return canPartitionRec(num, sum, index + 1);
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
