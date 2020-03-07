import sun.security.krb5.internal.crypto.Aes128;

public class SearchArrayBoundsUnknown {
    public static  int search(ArrayReader reader, int target) {
        int i = 0;
        int j = 1;

        while (reader.get(j)<target) {
            int k = j + 1;
            j += 2 * (j-i+1);
            i = k;
            if (reader.get(j) == 2147483647)
                return -1;
        }

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (reader.get(mid) == target)
                return mid;
            if (target < reader.get(mid))
                j = mid - 1;
            else
                i = mid + 1;
        }
        return -1;
    }

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2,5};
        int[] arr = {-1, 0, 3, 5, 9, 12};
        ArrayReader arrayReader = new ArrayReader(arr);
        System.out.println(search(arrayReader, 12));
    }
}
