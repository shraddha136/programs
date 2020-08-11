import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }

        int rowMin = 0;
        int colMin = 0;
        int rowMax = matrix.length-1;
        int colMax = matrix[0].length-1;
        int row = 1;
        int col = 0;
        List<Integer> result = new ArrayList<>();
        while(rowMin<=rowMax && colMin <= colMax){
            while(col<colMax){
                result.add(matrix[rowMin][col++]);
            }
            while(row<rowMax){
                result.add(matrix[row++][colMax]);
            }

            if(rowMin<rowMax && colMin<colMax){
                while(col>colMin){
                    result.add(matrix[rowMax][--col]);
                }

                while(row>rowMin){
                    result.add(matrix[row--][colMin]);
                }
            }

            rowMin++;
            rowMax--;
            colMin++;
            colMax--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new SpiralMatrix().spiralOrder(m));
    }
}
