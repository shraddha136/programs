import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation

 */
public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack;
    Integer current;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        if(!nestedList.isEmpty()){
            stack.push(nestedList.iterator());
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
            Integer res = current;
            current = null;
            return res;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && current == null){
            Iterator<NestedInteger> node = stack.peek();
            if(!node.hasNext()){
                stack.pop();
                continue;
            }
            NestedInteger val = node.next();
            if(val.isInteger()){
                current = val.getInteger();
                return true;
            }else{
                stack.push(val.getList().iterator());
            }
        }
        return false;
    }
}
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */