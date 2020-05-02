import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SquareSubMatrix {
    public int squareSubMatrix(int[][] matrix) {
        int size = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==0 || j == 0)
                    dp[i][j] = matrix[i][j];
                else if(matrix[i][j]==1)
                    dp[i][j] =  Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                if(dp[i][j]>size)
                   size = dp[i][j];
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 0}};
        System.out.println(new SquareSubMatrix().squareSubMatrix(matrix));
    }
}
