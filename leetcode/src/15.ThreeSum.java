import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i-1]){
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        result.add(res);
                    }
                    if (sum < 0) {
                        int currJ = j;
                        while (nums[currJ] == nums[j] && j < k) {
                            j++;
                        }
                    } else {
                        int currK = k;
                        while (nums[currK] == nums[k] && j < k) {
                            k--;
                        }
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
