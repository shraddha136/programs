import java.util.*;

public class Meetings {

    class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    PriorityQueue<Meeting> heap = new PriorityQueue<>((a, b) -> (a.end - b.end));

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int rooms = 0;
        List<Meeting> meetings = new ArrayList<>();
        for (int[] interval : intervals) {
            meetings.add(new Meeting(interval[0], interval[1]));
        }
        for (Meeting m : meetings) {
            if (heap.isEmpty()) {
                heap.offer(m);
                rooms++;
            } else if (heap.peek().end < m.start) {
                heap.poll();
                heap.offer(m);
            } else {
                heap.offer(m);
                rooms++;
            }
        }
        return rooms;
    }
}

