import java.util.*;

class HitCounter {

    Queue<Integer> queue;
    Map<Integer,Integer> timeCount;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
        timeCount = new HashMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(timeCount.containsKey(timestamp)){
            timeCount.put(timestamp, timeCount.get(timestamp)+1);
        }else{
            update(timestamp);
            queue.add(timestamp);
            timeCount.put(timestamp,1);
        }
    }

    private void update(int timestamp){
        while(!queue.isEmpty() && queue.peek()<=timestamp-300){
            timeCount.remove(queue.poll());
        }
    }


    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        update(timestamp);
        int total = 0;
        for(int t: timeCount.values()){
            total += t;
        }
        return total;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);

// get hits at timestamp 4, should return 3.
        counter.getHits(4);

// hit at timestamp 300.
        counter.hit(300);

// get hits at timestamp 300, should return 4.
        counter.getHits(300);

// get hits at timestamp 301, should return 3.
        counter.getHits(301);
    }
}
