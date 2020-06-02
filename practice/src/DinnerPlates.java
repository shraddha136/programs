import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DinnerPlates {

    List<Stack<Integer>> allStacks;
    int maxCap;
    int fullSize;

    public DinnerPlates(int capacity) {
        this.maxCap = capacity;
        allStacks = new ArrayList<>();
        this.fullSize = 0;
    }

    public void push(int val) {
        int i = 0;
        if (allStacks.size() == 0) {
            allStacks.add(new Stack<>());
            fullSize++;
        } else {

            while (i < fullSize &&   allStacks.get(i).size() == maxCap) {
                i++;
            }
            if(i == fullSize) {
                allStacks.add(new Stack<>());
                fullSize++;
            }
        }
        allStacks.get(i).push(val);
    }

    public int pop() {
        if (allStacks.size() == 0 || allStacks.get(fullSize - 1) == null || allStacks.get(fullSize - 1).isEmpty())
            return -1;
        int popped =  allStacks.get(fullSize - 1).pop();
        if(allStacks.get(fullSize-1).isEmpty()) {
            allStacks.remove(fullSize-1);
            fullSize--;
        }
        return popped;
    }

    public int popAtStack(int index) {
        if (allStacks.size() == 0 || allStacks.get(index).isEmpty())
            return -1;
        int popped =  allStacks.get(index).pop();
        if(allStacks.get(index).size() == 0){
            allStacks.remove(fullSize-1);
            fullSize--;
        }

        return popped;
    }

    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(2);  // Initialize with capacity = 2
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);         // The stacks are now:  2  4
//        1  3  5
//                                           ﹈ ﹈ ﹈
        D.popAtStack(0);   // Returns 2.  The stacks are now:     4
//        1  3  5
//                                                       ﹈ ﹈ ﹈
        D.push(20);        // The stacks are now: 20  4
//        1  3  5
//                                           ﹈ ﹈ ﹈
        D.push(21);        // The stacks are now: 20  4 21
        //    1  3  5
        //                                        ﹈ ﹈ ﹈
        D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
        //    1  3  5
        //                                                     ﹈ ﹈ ﹈
        D.popAtStack(2);   // Returns 21.  The stacks are now:     4
        //    1  3  5
        //                                                    ﹈ ﹈ ﹈
        D.pop();          // Returns 5.  The stacks are now:      4
        //     1  3
        //                                                    ﹈ ﹈
        D.pop();            // Returns 4.  The stacks are now:   1  3
        //                                                  ﹈ ﹈
        D.pop();            // Returns 3.  The stacks are now:   1
        //                                                  ﹈
        D.pop();            // Returns 1.  There are no stacks.
        D.pop();           // Returns -1.  There are still no stacks.
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */