import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    private PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int rooms = 0;
        for (int[] interval : intervals) {
            if (pq.isEmpty() || pq.peek()[1] > interval[0]) {
                pq.offer(interval);
            } else {
                while (!pq.isEmpty() && pq.peek()[1] < interval[0]) {
                    pq.poll();
                }
                pq.offer(interval);
            }
            rooms = Math.max(rooms,pq.size());
        }
        return rooms;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,5},{8,9},{8,9}};
        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        System.out.println(new MeetingRooms2().minMeetingRooms(intervals));
    }
}
