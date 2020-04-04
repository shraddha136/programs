class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int available = 0;
        int j = 0;
        while (available < nums.length && j < nums.length) {
            while (nums[j] == 0 && j < nums.length) {
                j++;
            }
            if (j < nums.length) {
                nums[available] = nums[j];
                j++;
                available++;
            }
        }
        while ((available<nums.length))
            nums[available++] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
    }
}
