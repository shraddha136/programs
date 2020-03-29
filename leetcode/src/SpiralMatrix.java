import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        int iMin = 0;
        int jMin = 0;
        int iMax = matrix.length - 1;
        int jMax = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (i >= iMin) {
            while (j < jMax)
                list.add(matrix[i][j++]);
            iMin += 1;

            while (i < iMax)
                list.add(matrix[i++][j]);
            jMax -= 1;

            while (j > jMin)
                list.add(matrix[i][j--]);

            while(i >iMin)
                list.add(matrix[i--][j]);
            jMin += 1;
            iMax -= 1;
        }
        list.add(matrix[i][j]);
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
