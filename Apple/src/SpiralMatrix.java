import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowMin = 0;
        int rowMax = matrix.length-1;
        int colMin = 0;
        int colMax = matrix[0].length-1;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while(rowMin <= rowMax && colMin <= colMax){
            for(i = colMin;i<=colMax;++i){
                result.add(matrix[rowMin][i]);
            }
            rowMin++;

            for(j = rowMin;j<=rowMax;++j){
                result.add(matrix[j][colMax]);
            }
            colMax--;

            if(rowMin < rowMax){
                for(i = colMax;i>=colMin;--i){
                    result.add(matrix[rowMax][i]);
                }
                rowMax--;
            }

            if(colMin < colMax){
                for(j = rowMax;j>=rowMin;--j){
                    result.add(matrix[j][colMin]);
                }
                colMin++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

       int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};
        System.out.println(Arrays.deepToString(a));
        System.out.println(new SpiralMatrix().spiralOrder(a));
        System.out.println(new SpiralMatrix().spiralOrder(b));
    }
}
