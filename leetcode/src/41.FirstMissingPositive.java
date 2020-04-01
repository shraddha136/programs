public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        int i = 0;
        while(i<nums.length){
            if(0<nums[i] && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }

        for(int m = 0;m<nums.length;m++){
            if(nums[m]!=m+1)
                return m+1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1,1}));
    }
}
