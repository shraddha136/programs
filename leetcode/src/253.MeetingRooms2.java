import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class MeetingRooms2 {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        List<Interval> intervalList = buildIntervals(intervals);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> (a.end - b.end));

        int rooms = 0;
        for (Interval interval : intervalList) {
            if (minHeap.isEmpty() || minHeap.peek().end > interval.start) {
                minHeap.offer(interval);
                rooms++;
            } else if (minHeap.peek().end <= interval.start) {
                minHeap.poll();
                minHeap.offer(interval);
            }
        }
        return rooms;
    }

    private List<Interval> buildIntervals(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        return intervalList;
    }

    public static void main(String[] args) {
        int[][] intervals = {{7, 10},{2, 4}};
//        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        System.out.println(new MeetingRooms2().minMeetingRooms(intervals));
    }
}
