import java.util.*;

public class DominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        if (A == null && B == null || A.length == 0 && B.length == 0)
            return 0;



        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new DominoRotations().minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
    }
}
