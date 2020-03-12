import java.util.ArrayList;
import java.util.List;

public class AllMissing {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        int i = 0;
        for (i = 0; i < n; i++) {
            while (nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                if(nums[i]==nums[nums[i]-1])
                    break;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println(findNumbers(a));
        a = new int[]{2, 4, 1, 2};
        System.out.println(findNumbers(a));
    }
}
