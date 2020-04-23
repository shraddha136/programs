public class LoadBalancing {
    public boolean loadBalance(int[] load) {
        if (load.length < 2)
            return false;
        int totalSum = 0;
        int leftSum = load[0];
        int rightSum = load[load.length-1];
        int dropSum = 0;
        int midSum = 0;

        for (int n : load)
            totalSum += n;
        int left = 1;
        int right = load.length - 2;
        while (left <= right) {
            dropSum = load[left] + load[right];
            midSum = totalSum - (dropSum + leftSum + rightSum);

            if(midSum < leftSum || midSum < rightSum)
                return false;
            if (leftSum == rightSum && rightSum == midSum)
                return true;

            if (leftSum < rightSum) {
                leftSum += load[left];
                left++;
            }else{
                rightSum += load[right];
                right--;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LoadBalancing().loadBalance(new int[]{1, 3, 4, 2, 2, 2, 1, 1, 2}));
    }
}
