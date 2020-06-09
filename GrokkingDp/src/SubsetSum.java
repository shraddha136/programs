public class SubsetSum {
    public boolean canPartition(int[] num, int sum) {
        return canPartitionRec(num, sum, 0);
    }

    private boolean canPartitionRec(int[] num, int sum, int index) {
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
        SubsetSum ss = new SubsetSum();
        int[] num = {1, 2, 3, 7};
        System.out.println(ss.canPartition(num, 6));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.canPartition(num, 10));
        num = new int[]{1, 3, 4, 8};
        System.out.println(ss.canPartition(num, 6));
    }
}
