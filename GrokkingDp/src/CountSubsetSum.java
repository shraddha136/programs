public class CountSubsetSum {
    public int countSubsets(int[] num, int sum) {
        return this.countSubsetsRecursive(num, sum, 0);
    }

    private int countSubsetsRecursive(int[] num, int sum, int index) {
        if(sum==0)
            return 1;
        if(num.length==0 || index >= num.length)
            return 0;

        int s1= 0;
        if(num[index]<=sum)
            s1 = countSubsetsRecursive(num,sum-num[index],index+1);
        int s2 = countSubsetsRecursive(num,sum,index+1);
        return s1 + s2;
    }
}
