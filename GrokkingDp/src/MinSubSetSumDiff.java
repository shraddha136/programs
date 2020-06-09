public class MinSubSetSumDiff {
    public static void main(String[] args) {
        MinSubSetSumDiff ps = new MinSubSetSumDiff();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }

    private int canPartition(int[] num) {
//        return canPartitionRec(num, 0, 0, 0);
        int sum = 0;
        for(int i:num)
            sum += i;
        Integer[][] memo = new Integer[num.length][sum+1];
        return canPartitionMemo(memo, num, 0, 0, 0);
    }

    private int canPartitionMemo(Integer[][] memo, int[] num, int sum1, int sum2, int index) {
        if (index == num.length)
            return Math.abs(sum1 - sum2);
        if(memo[index][sum1]==null){
            int diff1 = canPartitionRec(num, sum1 + num[index], sum2, index + 1);
            int diff2 = canPartitionRec(num, sum1, sum2 + num[index], index + 1);
            memo[index][sum1] = Math.min(diff1,diff2);
        }
        return memo[index][sum1];
    }

    private int canPartitionRec(int[] num, int sum1, int sum2, int index) {
        if (index == num.length)
            return Math.abs(sum1 - sum2);

        int diff1 = canPartitionRec(num, sum1 + num[index], sum2, index + 1);
        int diff2 = canPartitionRec(num, sum1, sum2 + num[index], index + 1);
        return Math.min(diff1,diff2);
    }
}
