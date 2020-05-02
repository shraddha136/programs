public class MatrixProduct {
//    public int matrixProduct(int[][] matrix) {
//        int[][] product = new int[matrix.length][matrix[0].length];
//        for (int i = 1; i < matrix.length; i++) {
//            product[i][0] = matrix[i - 1][0] * matrix[i][0];
//        }
//        for (int i = 1; i < matrix[0].length; i++) {
//            product[0][i] = matrix[0][i - 1] * matrix[0][i];
//        }
//        product[0][0] = matrix[0][0];
//        for (int i = 1; i < matrix.length; i++) {
//            for (int j = 1; j < matrix[0].length; j++) {
//                product[i][j] = matrix[i][j] * Math.max(product[i][j - 1], product[i - 1][j]);
//            }
//        }
//        return product[product.length - 1][product[0].length - 1];
//    }

    public static void main(String[] args) {
        int[][] matrix = {{-1, 2, 3}, {4, 5, -6}, {7, 8, 9}};
        System.out.println(new MatrixProduct().matrixProduct(matrix));
    }

    private int matrixProduct(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] min = new int[m][n];
        int[][] max = new int[m][n];
//        min[0][0] = max[0][0] = matrix[0][0];

//        for (int i = 1; i < m; i++) {
//            min[i][0] = min[i - 1][0] * matrix[i][0];
//            max[i][0] = max[i - 1][0] * matrix[i][0];
//        }
//        for (int i = 1; i < n; i++) {
//            min[0][i] = min[0][i - 1] * matrix[0][i];
//            max[0][i] = max[0][i - 1] * matrix[0][i];
//        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    min[i][j] = max[i][j] = matrix[i][j];
                    continue;
                }

                int maxMax = Integer.MIN_VALUE;
                int minMin = Integer.MAX_VALUE;
                if (i > 0) {
                    int tempMinI =  (Math.min(matrix[i][j] *min[i - 1][j], matrix[i][j] * max[i - 1][j]));
                    minMin = Math.min(minMin, tempMinI);
                    int tempMaxI =  (Math.max(matrix[i][j] *min[i - 1][j],matrix[i][j] * max[i - 1][j]));
                    maxMax = Math.max(maxMax, tempMaxI);
                }
                if (j > 0) {
                    int tempMinI = (Math.min(matrix[i][j] *min[i][j-1],matrix[i][j] * max[i][j-1]));
                    minMin = Math.min(minMin, tempMinI);
                    int tempMaxI = (Math.max(matrix[i][j] *min[i][j-1],matrix[i][j] * max[i][j-1]));
                    maxMax = Math.max(maxMax, tempMaxI);
                }
                min[i][j] = minMin;
                max[i][j] = maxMax;
            }
        }
        return max[m - 1][n - 1];
    }
}
