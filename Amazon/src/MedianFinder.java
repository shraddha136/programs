import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> minHeap= new PriorityQueue<>((a,b)->a-b);


    public void addNum(int num) {

        System.out.println(maxHeap.isEmpty());

        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        balanceHeap();
    }

    private void balanceHeap(){
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.poll();
        }
        return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */