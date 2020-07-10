import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class MaxPossibleValue {
    public static void main(String[] args) {
        int[] nums = {25, 4, 28, 1, 5, 1, 17, 2};
        System.out.println(maxPossibleSum(nums));
    }

    private static int maxPossibleSum(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    map.put(nums[i]+nums[j],map.getOrDefault(nums[i]+nums[j],0)+1);
                }
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)>1){
                return key;
            }
        }
        return -1;
    }
}
