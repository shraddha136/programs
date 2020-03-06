// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.

import java.util.PriorityQueue;

class ContinuousMedia {
    static class ContinuousMedianHandler {
        double median = 0;

        PriorityQueue<Integer> min = new PriorityQueue<Integer>((a,b)->a-b);
        PriorityQueue<Integer> max = new PriorityQueue<Integer>((a,b)->b-a);
        public void insert(int number) {
            // Write your code here.
            if(max.size()==0)
                max.offer(number);
            else{
                if(number>max.peek()){
                    min.offer(number);
                }else{
                    max.offer(number);
                }
            }
            balanceHeaps();
        }

        private void balanceHeaps() {
            if(max.size()+1==min.size()){
                max.offer(min.poll());
            }
            else if(max.size()>min.size()+1){
                min.offer(max.poll());
            }
        }

        public double getMedian() {
            if(max.size()==min.size())
                return (max.peek()+min.peek())/2.0;
            else
                return max.peek();

        }
    }

    public static void main(String[] args) {

        ContinuousMedianHandler cm = new ContinuousMedianHandler();
        cm.insert(5);
        System.out.println(cm.getMedian());
        cm.insert(10);
        System.out.println(cm.getMedian());
        cm.insert(100);
        System.out.println(cm.getMedian());
        cm.insert(200);
        System.out.println(cm.getMedian());
        cm.insert(6);
        System.out.println(cm.getMedian());
        cm.insert(13);
        System.out.println(cm.getMedian());
    }
}
