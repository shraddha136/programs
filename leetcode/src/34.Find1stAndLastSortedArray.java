import java.util.Arrays;

class Find1stAndLastSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int leftIdx = search(0, nums.length - 1, nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target)
            return new int[]{-1, -1};

        int rightIdx = search(0, nums.length - 1, nums, target, false) -1;
        return new int[]{leftIdx, rightIdx};
    }

    private int search(int start, int end, int[] nums, int target, boolean left) {

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target || left && nums[mid] == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new Find1stAndLastSortedArray().searchRange(nums, 8)));
        System.out.println(Arrays.toString(new Find1stAndLastSortedArray().searchRange(nums, 6)));
    }
}
