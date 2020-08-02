import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryUsage {
    public static void main(String[] args) {
        int[] foregroundTasks = {1, 7, 2, 4, 5, 6};
        int[] backgroundTasks = {3, 1, 2};
//        int[] backgroundTasks = {1, 1, 2};
        int k = 10;
        System.out.println(getOptimal(foregroundTasks, backgroundTasks, k));
    }

    private static List<List<Integer>> getOptimal(int[] foregroundTasks, int[] backgroundTasks, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(foregroundTasks);
        Arrays.sort(backgroundTasks);
        int i = 0;
        int j = backgroundTasks.length - 1;

        int maxTotal = Integer.MIN_VALUE;
        while (i < foregroundTasks.length && j >= 0) {
            if(foregroundTasks[i]==k){
                result.add(Arrays.asList(i,-1));
            }
            int total = foregroundTasks[i] + backgroundTasks[j];
            if(total > k){
                continue;
            }
            if(maxTotal < total){
                maxTotal = total;
                result.clear();
            }
            result.add(Arrays.asList(i,j));
            int m = j-1;
            while (m >= 0 && backgroundTasks[j]==backgroundTasks[m--]){
                result.add(Arrays.asList(i,m));
            }
        }

        return result;
    }
}
