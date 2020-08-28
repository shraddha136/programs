import java.util.*;


public class MinInterval {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> startPoints = new TreeMap<>();
        for(int i=0; i<intervals.length; i++){
            startPoints.put(intervals[i][0], i);
        }

        int[] ans = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            Integer nextClosestStartPoint = startPoints.ceilingKey(intervals[i][1]);
            ans[i]= nextClosestStartPoint==null ? -1 : startPoints.get(nextClosestStartPoint);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{3, 4}, {2, 3}, {1, 2}};
        System.out.println(Arrays.toString(new MinInterval().findRightInterval(a)));
    }

}
