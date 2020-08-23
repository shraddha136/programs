import java.util.Arrays;

public class ParitySort {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && A[i] % 2 == 0) {
                i++;
            }
            if (i == A.length) {
                break;
            }
            while (i < j && A[j] % 2 != 0) {
                j--;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4};
        System.out.println(Arrays.toString(new ParitySort().sortArrayByParity(a)));
    }
}
