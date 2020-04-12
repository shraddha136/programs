import java.util.PriorityQueue;

public class StoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0)
            return 0;
        if(stones.length == 1)
            return stones[0];
        if(stones.length == 2)
            return Math.abs(stones[0]-stones[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for(int n:stones)
            maxHeap.add(n);

        while(!maxHeap.isEmpty()){
            if(maxHeap.size()==1)
                return maxHeap.peek();
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first>second)
                maxHeap.add(first-second);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new StoneWeight().lastStoneWeight(stones));
    }
}
