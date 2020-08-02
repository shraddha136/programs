public class MaximalMinimum {
    public static void main(String[] args) {
        int[][] m = {{7, 5, 3},
                {2, 0, 9},
                {4, 5, 9}};

        System.out.println(getMinMax(m));

        int[][] b = {{5, 1},
                {4, 5}};
        System.out.println(getMinMax(b));

        int[][] a = {{1, 2, 3},
                {4, 5, 1}};
        System.out.println(getMinMax(a));

    }

    private static int getMinMax(int[][] m) {
        int[][] dp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = m[i][j];
                } else if (i == m.length - 1 && j == m[0].length - 1) {
                    return Math.max(dp[i][j - 1], dp[i - 1][j]);
                } else if (j == 0) {
                    if(i == 1){
                        dp[i][j] = m[i][j];
                    }else{
                        dp[i][j] = Math.min(m[i - 1][j], m[i][j]);
                    }
                } else if (i == 0) {
                    if(j == 1){
                        dp[i][j] = m[i][j];
                    }
                    dp[i][j] = Math.min(m[i][j - 1], m[i][j]);
                } else {
                    dp[i][j] = Math.min(m[i][j], Math.max(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return -1;
    }
}
