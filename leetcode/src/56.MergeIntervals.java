import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)
            return intervals;


        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int i = 0;
        int j = 0;

//        merged.add(intervals[j]);
        int[] interval = intervals[i];
        while (i < intervals.length - 1) {
            int[] nextInterval = intervals[i + 1];
            if (interval[1] >= nextInterval[0]) {
                interval[1] = Math.max(interval[1], nextInterval[1]);
            } else {
                merged.add(interval);
                interval = nextInterval;
            }
            i++;

        }
        merged.add(interval);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
    }
}
