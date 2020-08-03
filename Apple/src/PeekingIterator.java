// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer next;
    boolean noSuchElements;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        advance();
    }

    private void advance() {
        if(it.hasNext()){
            next = it.next();
        }else{
            noSuchElements = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(noSuchElements){
            throw new NoSuchElementException();
        }
        Integer res = next;
        advance();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !noSuchElements;
    }
}