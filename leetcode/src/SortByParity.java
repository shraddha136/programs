import java.util.Arrays;

public class SortByParity {
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int even = 0;

       for(int odd = 0;odd< nums.length;odd++){
           if(nums[odd]%2==0){
               int temp = nums[odd];
               nums[odd] = nums[even];
               nums[even] = temp;
               even++;
           }
       }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortByParity().sortArrayByParity(new int[]{3,1,2,4})));
    }
}
