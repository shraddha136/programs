import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumUnique {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1,-1};
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int currI = i;
            while (i < nums.length - 1 && nums[i + 1] == nums[currI])
                i++;
            int currJ = j;
            while (j > 0 && nums[j - 1] == nums[currJ])
                j--;
            if (nums[i] + nums[j] == target)
                return new int[]{nums[i], nums[j]};
            if(nums[i] + nums[j] < target)
                i++;
            else
                j--;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumUnique().twoSum(new int[]{2,7,11,15}, 9)));
    }
}
