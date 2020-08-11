import java.util.Arrays;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        int maxLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    maxLen = Math.max(maxLen,dfs(matrix, i, j, Integer.MIN_VALUE, dp));
                }
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j, int minValue, int[][] dp) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= minValue) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = 1 + Math.max(Math.max(Math.max(dfs(matrix, i - 1, j, matrix[i][j], dp), dfs(matrix, i + 1, j, matrix[i][j], dp)), dfs(matrix, i, j-1, matrix[i][j], dp)), dfs(matrix, i , j+1, matrix[i][j], dp));
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] a = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(a));
    }
}
