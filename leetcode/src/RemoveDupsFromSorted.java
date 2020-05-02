public class RemoveDupsFromSorted {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length - 1) {
            while(j<nums.length && nums[j]==nums[i])
                j++;
            if(j<nums.length){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }else
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDupsFromSorted().removeDuplicates(nums));
    }
}

