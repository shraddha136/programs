import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Optimization {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        List<int[]> result = new ArrayList<>();
        Collections.sort(a, (m, n) -> m[1] - n[1]);
        Collections.sort(b, (m, n) -> m[1] - n[1]);
        int i = 0;
        int j = b.size() - 1;
        int maxSum = Integer.MIN_VALUE;
        while (i < a.size() && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum > target)
                j--;
            else {
                if (sum > maxSum) {
                    maxSum = sum;
                    result.clear();
                }
                result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                int idx = j - 1;

                while (idx >= 0 && b.get(j)[0] == b.get(idx--)[0])
                    result.add(new int[]{a.get(i)[0], b.get(idx)[0]});
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 8}, {2, 7}, {3, 14}};
        int[][] b = {{1, 5}, {2, 10}, {3, 14}};
        System.out.println(new Optimization().getPairs(Arrays.asList(a), Arrays.asList(b), 20).toString());
    }
}
