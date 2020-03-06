import java.util.Arrays;

public class Find2dArray {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target)
                return new int[]{i, j};
            if (target < matrix[i][j])
                j = j - 1;
            else
                i = i + 1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}};
        System.out.println(Arrays.toString(searchInSortedMatrix(matrix, 128)));
    }
}
