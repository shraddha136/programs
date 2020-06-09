public class RodCutting {
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
//        return rodCutRec(lengths, prices, n, 0);
//        Integer[][] memo = new Integer[lengths.length][n+1];
//        return rodCutMemo(memo,lengths, prices, n, 0);
        return rodCutDp(lengths, prices, n);
    }

    private int rodCutDp(int[] lengths, int[] prices, int n) {
        int[][] dp = new int[prices.length][n + 1];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= n; j++) {
                int p1 = 0, p2 = 0;
                if (lengths[i] <= j) {
                    p1 = prices[i] + dp[i][j - lengths[i]];
                }
                if (i > 0) {
                    p2 = dp[i - 1][j];
                }
                dp[i][j] = Math.max(p1, p2);

            }
        }
        return dp[prices.length - 1][n];
    }

    private int rodCutMemo(Integer[][] memo, int[] lengths, int[] prices, int n, int index) {
        if (index == lengths.length || n <= 0 || prices.length != lengths.length)
            return 0;
        if (memo[index][n] == null) {
            int p1 = 0;
            if (lengths[index] <= n)
                p1 = prices[index] + rodCutRec(lengths, prices, n - lengths[index], index);
            int p2 = rodCutRec(lengths, prices, n, index + 1);
            memo[index][n] = Math.max(p1, p2);
        }
        return memo[index][n];
    }

    private int rodCutRec(int[] lengths, int[] prices, int n, int index) {
        if (index == lengths.length || n <= 0 || prices.length != lengths.length)
            return 0;
        int p1 = 0;
        if (lengths[index] <= n)
            p1 = prices[index] + rodCutRec(lengths, prices, n - lengths[index], index);
        int p2 = rodCutRec(lengths, prices, n, index + 1);
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}
