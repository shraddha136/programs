public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;

        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }else{
                if(nums[high] >= target && target>nums[mid])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray().search(new int[]{4,5,6,7,0,1,2, 3},3));
    }
}
