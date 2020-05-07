import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        int i = 0;
        for(int j = i+1;j<array.length;j++){
            if(array[j]<array[j-1]){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                sort(array,i,j-1);
            }
        }
        return array;
    }

    private static void sort(int[] array, int i, int j) {
        for(int m = j;m>i;m--){
            if(array[m]<array[m-1]){
                int temp = array[m];
                array[m] = array[m-1];
                array[m-1] = temp;
            }
        }
    }

    public static int[] selectionSort(int[] array) {
        for(int i = 0;i<array.length;i++){
            int min = i;
            for(int j = i+1;j<array.length;j++){
                if(array[j]<array[min])
                    min = j;
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

        public static void main(String[] args) {
        int[] num = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(insertionSort(num)));
        System.out.println(Arrays.toString(selectionSort(num)));
    }
}
