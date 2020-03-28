class SearchInSortedArray {

    //iterating twice over the array
//    public int search(int[] nums, int target) {
//        if(nums.length == 0)
//            return -1;
//        int startOfMin = findStart(nums);
//        int res = find(0, startOfMin - 1, nums,target);
//        if (res == -1)
//            res = find(startOfMin, nums.length-1, nums, target);
//        return res;
//    }
//
//    private int find(int start, int end, int[] nums, int target) {
//        while(start<=end){
//            int mid = end + (start - end)/2;
//            if(nums[mid] == target)
//                return mid;
//            if(target < nums[mid])
//                end = mid - 1;
//            else
//                start = mid + 1;
//        }
//        return -1;
//    }
//
//    private int findStart(int[] nums) {
//        for(int i = 1;i<nums.length;i++){
//            if(nums[i]<nums[i-1])
//                return i;
//        }
//        return 0;
//    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new SearchInSortedArray().search(nums, 2));
    }

    //iterate over the array once
    private int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[start]) { // we're in the non--rotated part of array
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
