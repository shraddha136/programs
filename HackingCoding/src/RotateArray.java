import java.util.Arrays;
import java.util.List;

class RotateArray {
    static void rotateArray(List<Integer> arr, int n) {
        //TODO: Write - Your - Code
        n = n % arr.size();

        if (n < 0)
            n += arr.size();

        //reverse the array
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }

        //rotate 0->n-1
        i = 0;
        j = n - 1;
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }

        //rotate n -> len - 1
        i = n;
        j = arr.size() - 1;
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n" + arr);
        rotateArray(arr, 2);
        System.out.println("Array After Rotation\n" + arr);
    }
} 