import java.util.ArrayList;
import java.util.List;

class MinStack {
    /** initialize your data structure here. */
    int min;
    List<Integer> stack;
    int size;
    public MinStack() {
        stack = new ArrayList<>();
        min = Integer.MAX_VALUE;
        size = 0;
    }

    public void push(int x) {
        stack.add(size,x);
        min = Math.min(min,x);
        size++;
    }

    public void pop() {
        stack.remove(size-1);
        size--;
    }

    public int top() {
        return stack.get(size-1);
    }

    public int getMin() {
        return min;
    }
}
