import java.util.ArrayList;
import java.util.List;

class MinStack2 {

    /** initialize your data structure here. */
    class Node {
        int num;
        int min;

        Node(int num, int min) {
            this.num = num;
            this.min = min;
        }
    }

    List<Node> stack;
    int size;
    int min;

    public MinStack2() {
        stack = new ArrayList<Node>();
        min = Integer.MAX_VALUE;
        size = 0;
    }

    public void push(int x) {
        min = Math.min(min, x);
        stack.add(new Node(x, min));
        size++;
    }

    public void pop() {
        stack.remove(size - 1);
        size--;
        if (size == 0)
            min = Integer.MIN_VALUE;
        else
            min = stack.get(size - 1).min;
    }

    public int top() {
        Node i = stack.get(size - 1);
        return i.num;
    }

    public int getMin() {
        if (size == 0)
            return Integer.MAX_VALUE;
        else
            return stack.get(size - 1).min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */