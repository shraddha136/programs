import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;


        List<Integer> set = new ArrayList<>();


        for (int i = nums[0]; i < nums[nums.length-1] + k; i++) {
           set.add(i);
        }

        for(int num:nums){
            if(set.contains(num))
                set.remove((Integer) num);
        }
        if(set.size()>=k)
            return set.get(k-1);
        else{
            int already = set.size();
            int largest = nums[nums.length-1];
            for(int i = 0;i<k-already;i++)
                largest++;
            return largest;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 3;
        System.out.println(new MissingElementInSortedArray().missingElement(nums,k));
    }
}
