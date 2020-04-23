public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        int R = grid.length;
        int C = grid[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dp[i][j] += grid[i][j];
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[R - 1][C - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
    }
}
