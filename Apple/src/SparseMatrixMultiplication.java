import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;
        int[][] result = new int[aRow][bCol];

        for (int i = 0; i < aRow; i++) {
            for (int k = 0; k < aCol; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < bCol; j++) {
                        if (B[k][j] != 0) {
                            System.out.print("A:" + A[i][k] + "--B:" + B[k][j]);
                            result[i][j] += A[i][k] * B[k][j];
                        }

                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
        return result;
    }

//    public int[][] matMultiple(int[][] A, int[][] B) {
//        List<List<Pair<Integer, Integer>>> mat1 = buildList(A);
//        List<List<Pair<Integer, Integer>>> mat2 = buildList(B);
//        int aRow = A.length;
//        int aCol = A[0].length;
//        int bCol = B[0].length;
//        int[][] result = new int[aRow][bCol];
//        for (int i = 0; i < aRow; i++) {
//            for (int k = 0; k < aCol; k++) {
//                Pair<Integer,Integer> pair = mat1.get(i).get(k);
//                if (pair.getValue() != 0) {
//                    for (int j = 0; j < bCol; j++) {
//                        if(mat2.get(k).clear();)
//                        Pair<Integer,Integer> pairB = mat2.get(k).get(j);
//                        if (pairB.getValue() != 0) {
//                            System.out.print("A:" + pair.getValue() + "--B:" + pairB.getValue());
//                            result[i][j] += pair.getValue() * pairB.getValue();
//                        }
//
//                    }
//                    System.out.println();
//                }
//            }
//            System.out.println();
//        }
//        return result;
//    }
public int[][] multiply2(int[][] A, int[][] B) {
    int n = A.length, m = A[0].length, mb = B[0].length;
    int[][] res = new int[n][mb];
    ArrayList<int[]>[] nzA = new ArrayList[m]; // for each col of A, nzA saves non-zero elements' row number and value
    for (int j = 0; j < m; j++) nzA[j] = new ArrayList();

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (A[i][j] != 0) nzA[j].add(new int[]{i, A[i][j]});

    for (int i = 0; i < m; i++)
        for (int[] a : nzA[i]) // put it to inner will be 200ms
            for (int j = 0; j < mb; j++)
                if (B[i][j] != 0) res[a[0]][j] += B[i][j] * a[1];
    return res;
}
    private List<List<Pair<Integer, Integer>>> buildList(int[][] A) {
        List<List<Pair<Integer, Integer>>> matrix = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            matrix.add(i, new ArrayList<Pair<Integer, Integer>>());
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    matrix.get(i).add(new Pair<>(j, A[i][j]));
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 0, 0},
                {-1, 0, 3}
        };

        int[][] B = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(Arrays.deepToString(new SparseMatrixMultiplication().multiply2(A, B)));
    }
}
