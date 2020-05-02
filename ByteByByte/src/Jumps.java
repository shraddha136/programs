public class Jumps {
    public boolean canJump(int[] nums) {
        return check(0,nums);
    }

    private boolean check(int index, int[] nums) {
        if(index == nums.length-1)
            return true;
        int minJump = Math.min(index+nums[index],nums.length-1);
        for(int i = index+1;i<=minJump;i++){
            if(check(i,nums))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new Jumps().canJump(nums));
    }
}
