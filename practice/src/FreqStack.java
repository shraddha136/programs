import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {

    Map<Integer,Integer> stack;
    Map<Integer,Stack<Integer>> freq;
    int maxFreq;
    public FreqStack() {
        stack = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = stack.getOrDefault(x,0)+1;
        stack.put(x,f);
        if(f>maxFreq)
            maxFreq = f;
        freq.computeIfAbsent(f,z->new Stack<>()).push(x);
    }

    public int pop() {
        int x = freq.get(maxFreq).pop();
        stack.put(x,stack.get(x)-1);
        if(freq.get(maxFreq).size()==0)
            maxFreq--;
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */