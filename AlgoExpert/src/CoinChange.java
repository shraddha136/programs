import java.util.Arrays;

public class CoinChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        Arrays.sort(denoms);
        int[] change = new int[n + 1];
        Arrays.fill(change, Integer.MAX_VALUE);
        change[0] = 0;
        int temp = 0;
        for (int denom : denoms) {
            for (int i = 0; i < change.length; i++) {
                if (denom <= i){
                    if(change[i - denom] == Integer.MAX_VALUE)
                        temp = change[i - denom];
                    else
                        temp = 1  + change[i - denom];
                    change[i] = Math.min(change[i], temp);

                }
            }
        }
        return change[n] != Integer.MAX_VALUE ? change[n] : -1;
    }

    public static void main(String[] args) {
        int[] denoms = {2, 4};
        System.out.println(minNumberOfCoinsForChange(7, denoms));
    }
}
