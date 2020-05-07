import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int start = 0;
        int jump = getJump(start + array[start],array.length);
        int counts = 1;
        Set<Integer> set = new HashSet<>();
        set.add(start);
        while(jump != 0 && counts<array.length){
            start = jump;
            set.add(start);
            jump = getJump(start + array[jump],array.length);
            counts++;
        }
        return jump == 0 && set.size()==array.length;
    }
    private static int getJump(int jump, int length){
        jump %= length;
        if(jump < 0)
            jump += length;
        return jump;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,-4,-4,2};
        System.out.println(hasSingleCycle(array));
    }
}
