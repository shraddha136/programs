class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n ){
            if(nums[i]!=i && nums[i]<n){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }

        for(i = 0;i<nums.length;i++){
            if(nums[i]!=i)
                return i;
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
