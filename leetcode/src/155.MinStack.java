//import java.util.ArrayList;
//import java.util.List;
//
//class MinStack {
//    /** initialize your data structure here. */
//    int min;
//    List<Integer> stack;
//    int size;
//    public MinStack() {
//        stack = new ArrayList<MinStack.Node>();
//        min = Integer.MAX_VALUE;
//        size = 0;
//    }
//
//    public void push(MinStack.Node x) {
//        stack.add(size,x);
//        min = Math.min(min,x);
//        size++;
//    }
//
//    public void pop() {
//        stack.remove(size-1);
//        size--;
//    }
//
//    public MinStack.Node top() {
//        return stack.get(size-1);
//    }
//
//    public int getMin() {
//        return min;
//    }
//}
