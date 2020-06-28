import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BusiestTime {
    static class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    PriorityQueue<Interval> priorityQueue;

    BusiestTime(){
        priorityQueue = new PriorityQueue<>((a,b)->(a.end-b.end));
    }
    public List<Integer> getBusiestTime(List<Interval> intervals){
        List<Integer> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }
        Collections.sort(intervals, (a, b)->(a.start-b.start));

        int rooms = 0;
        int busyStart = 0;
        int busyEnd = 2000;
        for(int i = 0;i<intervals.size();i++){
            if(priorityQueue.isEmpty()){
                rooms++;
                priorityQueue.offer(intervals.get(i));
                busyStart = Math.max(busyStart,intervals.get(i).start);
                busyEnd = Math.min(busyEnd,intervals.get(i).end);
            }else if (priorityQueue.peek().end>intervals.get(i).start){
                rooms++;
                priorityQueue.offer(intervals.get(i));
                busyStart = Math.min(busyStart,intervals.get(i).start);
                busyEnd = Math.max(busyEnd,intervals.get(i).end);
            }else{
                priorityQueue.poll();
            }
        }

        result.add(busyStart);
        result.add(busyEnd);
        return result;
    }

    public static void main(String[] args) {
        Interval it = new Interval(100,300); // meeting 1, 1:00 am to 3:00 am
        Interval it1 = new Interval(145,215); // meeting 2
        Interval it2 = new Interval(200,230); // meeting 3
        Interval it3 = new Interval(215,300); // meeting 4
        Interval it4 = new Interval(215,400); // meeting 5
        Interval it5 = new Interval(500,600); // meeting 6
        Interval it6 = new Interval(600,700); // meeting 7
        List<Interval> intervals = new ArrayList<>();
        intervals.add(it);
        intervals.add(it1);
        intervals.add(it2);
        intervals.add(it3);
        intervals.add(it4);
        intervals.add(it5);
        intervals.add(it6);
        System.out.println(new BusiestTime().getBusiestTime(intervals));
    }
}
