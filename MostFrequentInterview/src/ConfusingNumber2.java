import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber2 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] num = {0, 1, 6, 8, 9};
    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int[] count = new int[1];
        dfs(0, N, num, count);
        return count[0];
    }
    private void dfs(long start, int N, int[] num, int[] count){
        if(start > N){
            return;
        }
        if(start <= N && isConfused(start, map)){
            count[0]++;
        }
        int i = start == 0 ? 1 : 0;
        for(; i < 5; i++){
            dfs(start * 10 + num[i], N, num, count);
        }
    }
    private boolean isConfused(long s, Map<Integer, Integer> map){
        long res = 0, x = s;
        while(x > 0){
            int i = (int) (x % 10);
            if(i == 2 || i == 3 || i == 4 || i == 5 || i == 7){
                return false;
            }
            long digit = map.get(i);
            res = res * 10 + digit;
            x = x / 10;
        }
        return res != s;
    }

    public static void main(String[] args) {
        System.out.println(new ConfusingNumber2().confusingNumberII(100));
    }
}
