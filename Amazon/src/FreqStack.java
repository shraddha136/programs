import javafx.util.Pair;

import java.util.*;

public class FreqStack {
    Map<Integer, Stack<Integer>> stackMap;
    Map<Integer, Integer> countMap;
    int maxFreq;

    public FreqStack() {
        stackMap = new HashMap<>();
        countMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = countMap.getOrDefault(x,0)+1;

        Stack<Integer> stack = new Stack<>();
        if(stackMap.containsKey(f)){
            stack = stackMap.get(f);
        }
        stack.push(x);
        stackMap.put(f,stack);
        countMap.put(x,f);
        maxFreq = Math.max(maxFreq,countMap.get(x));
    }

    public int pop() {
        if (countMap.size() == 0) {
            return -1;
        }
        int pop = stackMap.get(maxFreq).pop();
        if (stackMap.get(maxFreq).size() == 0) {
            stackMap.remove(maxFreq);
            maxFreq--;
        }
        countMap.put(pop, countMap.get(pop) - 1);
        if (countMap.get(pop) == 0) {
            countMap.remove(pop);
        }
        return pop;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(4);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        System.out.println(freqStack.pop());
        freqStack.push(6);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
