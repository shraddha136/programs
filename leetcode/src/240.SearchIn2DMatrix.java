class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j])
                return true;
            if (target < matrix[i][j])
                i--;
            else
                j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new SearchIn2DMatrix().searchMatrix(matrix, 5));
        System.out.println(new SearchIn2DMatrix().searchMatrix(matrix, 20));
        System.out.println(new SearchIn2DMatrix().searchMatrix(matrix, 1));
    }
}
