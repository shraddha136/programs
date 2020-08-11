import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i = 0;i<strNums.length;i++){
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return b.compareTo(a);
            }
        });
        String res = String.join("",strNums);
        if(res.isEmpty() || res.charAt(0)=='0'){
            return "0";
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {3,30,34,5,9};
        System.out.println(new LargestNumber().largestNumber(a));
    }
}
