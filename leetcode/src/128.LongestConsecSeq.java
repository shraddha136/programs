import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LongestConsecSeq {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int max = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            if (nums[i] == nums[i - 1] + 1)
                maxLen++;
            else {
                max = Math.max(max, maxLen);
                maxLen = 1;
            }
        }
        return  Math.max(max, maxLen);
    }

    public int lcseq(int[] nums){
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for(int n:nums)
            set.add(n);

        for(int n: set){
            if(!set.contains(n-1)){
                int curr = n;
                int currLen = 1;
                while (set.contains(curr+1)){
                    curr +=1;
                    currLen +=1;
                }
                maxLen = Math.max(currLen,maxLen);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
//        int[] nums = {0,-1};
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println(new LongestConsecSeq().lcseq(nums));
    }
}
