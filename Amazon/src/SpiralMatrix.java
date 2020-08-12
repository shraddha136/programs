import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] b = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(spiralMatrix(a));
        System.out.println(spiralMatrix(b));
    }

    private static List<Integer> spiralMatrix(int[][] a) {
        int rowMin = 0;
        int rowMax = a.length;
        int colMin = 0;
        int colMax = a[0].length;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while(rowMin < rowMax && colMin<colMax){
            i = rowMin;
            for(int k = colMin;k<colMax;++k){
                result.add(a[i][k]);
            }
            rowMin++;

            j = colMax-1;
            for(int k = rowMin;k<rowMax;++k){
                result.add(a[k][j]);
            }
            colMax--;

            if(rowMin<rowMax){
                i = rowMax-1;
                for(int k = colMax-1;k>=colMin;--k){
                    result.add(a[i][k]);
                }
                rowMax--;
            }

            if(colMin<colMax){
                j = colMin;
                for(int k = rowMax-1;k>=rowMin;--k){
                    result.add(a[k][j]);
                }
                colMin++;
            }

        }
        return result;
    }
}
