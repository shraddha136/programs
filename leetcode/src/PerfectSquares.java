import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        // array with squares less than number
        //like coin problem?

        int[] squares = new int[n+1];
        for (int i = 0; i <= n; i++) {
            squares[i] = i * i;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int sq : squares) {
            for (int i = 0; i <= n; i++) {
                if (sq <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - sq]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
        System.out.println(new PerfectSquares().numSquares(1));
    }

}
