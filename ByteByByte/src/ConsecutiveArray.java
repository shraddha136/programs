import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArray {
    public static void main(String[] args) {
        int[] a = {4,2,1,6,5};
        int[] b = {5,5,3,1};
        System.out.println(new ConsecutiveArray().longestSequence(a));
        System.out.println(new ConsecutiveArray().longestSequence(b));
    }

    private int longestSequence(int[] a) {
        int maxLen = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num:a)
            set.add(num);
        for(int i = 0;i<a.length;i++){
            if(set.contains(a[i]-1))
                continue;
            int j = a[i];
            int len = 1;
            while(set.contains(j+1)){
                len++;
                j++;
            }
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
}
