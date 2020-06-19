public class CycleArray {
    public int hasCycle(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int count = 0;
        int startIndex =0;
        int fast = arr[arr[startIndex]];
        int slow = arr[startIndex];
        while (fast != slow) {
            if (fast >= arr.length)
                return -1;
            count++;
            fast = arr[arr[fast]];
            slow = arr[slow];
        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums = {1, 0};
        System.out.println(new CycleArray().hasCycle(nums));
        nums = new int[]{1, 2, 0};
        System.out.println(new CycleArray().hasCycle(nums));
        nums = new int[]{1, 2, 3, 1};
        System.out.println(new CycleArray().hasCycle(nums));
    }
}
