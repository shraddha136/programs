import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = -1;
        List<List<Integer>> list = new ArrayList<>();
        // TODO: Write your code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] < target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(arr[i]);
                    l.add(arr[j]);
                    l.add(arr[k--]);
                    list.add(l);
                } else {
                    j++;
                }
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
