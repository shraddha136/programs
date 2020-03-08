public class CyclicSort {
    public static void sort(int[] nums) {

        for(int i = 0;i<nums.length;i++){
            while(nums[i]!=i+1){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                 nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 4, 2};
        sort(a);
    }
}
