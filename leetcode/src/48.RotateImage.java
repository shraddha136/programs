class RotateImage {
    public void rotate(int[][] matrix) {
        swapDiagonallyOpp(matrix);
        swapColumns(matrix);
    }

    private void swapDiagonallyOpp(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i ; j++) {
                swap(i, j, matrix);
            }
        }
    }

    private void swap(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void swapColumns(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            int k = matrix[0].length - 1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new RotateImage().rotate(matrix);
    }
}
