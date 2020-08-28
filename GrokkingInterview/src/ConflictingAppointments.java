import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
};

class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        // TODO: Write your code here
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval it = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(it.end> intervals[i].start){
                return false;
            }
            it = intervals[i];
        }
        return true;
    }

    public static List<Interval> findConflicting(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Set<Interval> result = new HashSet<>();
        Interval it = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(it.end> intervals[i].start){
                result.add(it);
                result.add(intervals[i]);
            }
            it = intervals[i];
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);
        System.out.println("Can attend all appointments: " + ConflictingAppointments.findConflicting(intervals));

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);
        System.out.println("Can attend all appointments: " + ConflictingAppointments.findConflicting(intervals1));


        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
        System.out.println("Can attend all appointments: " + ConflictingAppointments.findConflicting(intervals2));

    }
}
