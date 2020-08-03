import java.util.HashMap;
import java.util.Map;

public class ShortestSubarray {
    public int shortestSubarray(int[] A, int K) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int len = Integer.MAX_VALUE;

        int start = 0;
        for(int end = 0;end < A.length;end++){
            sum += A[end];
            while(sum >= K){
                len = Math.min(len, end - start + 1);
                sum -= A[start++];
            }
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }

    public static void main(String[] args) {
        int[] A = {17,85,93,-45,-21};
        System.out.println(new ShortestSubarray().shortestSubarray(A,150));
    }
}
