import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> numberQueue;
    int size;
    double total;

    public MovingAverage(int size) {
        this.size = size;
        numberQueue = new LinkedList();
        this.total = 0;
    }

    public double next(int val) {
        numberQueue.offer(val);
        total += val;
        if (numberQueue.size() <= size) {
            return total / numberQueue.size();
        } else {
            int front = numberQueue.poll();
            this.total -= front;
            return total / size;
        }
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        m.next(1);
        m.next(10);
        m.next(3);
        m.next(5);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */