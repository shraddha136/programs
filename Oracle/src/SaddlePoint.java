import java.util.*;

public class SaddlePoint {
    public int findSaddlePoint(int[][] matrix) {
        for(int i = 0;i<matrix.length;i++){

            int minInRow = matrix[i][0];
            int minCol = 0;
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]<minInRow){
                    minInRow = matrix[i][j];
                    minCol = j;
                }
            }


            int maxInCol = matrix[i][minCol];
            int max = maxInCol;
            for(int k = 0;k<matrix.length;k++){
                if(maxInCol<matrix[k][minCol]){
                    maxInCol = Integer.MIN_VALUE;
                    break;
                }
            }
            if(max == maxInCol){
                return maxInCol;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = { {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(new SaddlePoint().findSaddlePoint(mat));
    }
}
