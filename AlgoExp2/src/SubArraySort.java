import java.util.Arrays;

class SubArraySort {
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        if (array == null || array.length <= 1)
            return array;
        int[] res = {-1, -1};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (!outOfOrder(array[i], array, i)) {
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i]);
            }
        }
        if (min == Integer.MAX_VALUE)
            return res;
        int i = 0;
        while (i < array.length && array[i] <= min)
            i++;
        int j = array.length - 1;
        while (j > 0 && array[j] >= max)
            j--;
        res[0] = i;
        res[1] = j;
        return res;
    }


    private static boolean outOfOrder(int x, int[] array, int i) {
        if (i == 0)
            return x < array[i + 1];
        if (i == array.length - 1)
            return x > array[i-1];

        return array[i - 1] < x && x < array[i + 1];
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
    }
}
