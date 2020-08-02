import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int sum = 0;
        int j = 0;
        int count = 0;
        while (i < nums.length) {
            sum += nums[i];

            while (sum >= k) {
                if (sum == k)
                    count++;
                sum -= nums[j++];
            }

            i++;
        }
        return count;
    }

    //with map
    public int getSum(int[] a,int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int n : a){
            sum += n;
            if(map.containsKey(sum - target)){
                count += map.get(sum-target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
//        int[] nums = {1, 5,1};
        int[] nums = {1,2,3,7,8};
        System.out.println(new SubarraySumK().getSum(nums, 3));
    }
}
