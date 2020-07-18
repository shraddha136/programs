import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalUtilization {
    public List<List<Integer>> getOptimal(int[][] a, int[][] b, int target) {
        Arrays.sort(a, (m, n) -> (m[1] - n[1]));
        Arrays.sort(b, (m, n) -> (m[1] - n[1]));

        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = b.length - 1;
        int max = Integer.MIN_VALUE;
        int temp = 0;
        while (i < a.length && j >= 0) {
            System.out.println(++temp);
            int sum = a[i][1] + b[j][1];
            if (sum > target) {
                j--;
            } else if (sum >= max) {
                if (sum > max) {
                    result = new ArrayList<>();
                    max = sum;
                }
                List<Integer> list = new ArrayList<>();
                list.add(a[i][0]);
                list.add(b[j][0]);
                result.add(list);
                int index = j;
                while (j > 0 && b[j][1] == b[j - 1][1]) {
                    System.out.println(++temp);
                    list = new ArrayList<>();
                    list.add(a[i][0]);
                    list.add(b[j][0]);
                    result.add(list);
                    j--;
                }
                i++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
//        int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] a = {{1, 8}, {2, 8}, {3, 8},{4,8}};
        int[][] b = {{1, 8}, {2, 8}, {3, 8}};
//        int[][] b = {{1, 8}, {2, 11}, {3, 12}};
        System.out.println(new OptimalUtilization().getOptimal(a, b, 16));
    }
}
