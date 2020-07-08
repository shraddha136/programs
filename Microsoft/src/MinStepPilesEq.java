import javafx.util.Pair;

import java.util.*;

public class MinStepPilesEq {
    public static int makePilesEq(Integer[] ar){
        if(ar == null || ar.length == 0){
            return 0;
        }

        Arrays.sort(ar, Collections.reverseOrder());
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:ar){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());

        int count = 0;
        while(pq.size()>1){
            Map.Entry<Integer,Integer> c1 = pq.poll();
            Map.Entry<Integer,Integer> c2 = pq.poll();
            count += c1.getValue();
            c2.setValue(c1.getValue()+c2.getValue());
            pq.offer(c2);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(makePilesEq(new Integer[]{2,4,5,5,4}));
    }
}
