import java.util.*;

class TopKFreq {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<HashMap.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));

        for(HashMap.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(entry);
            if(queue.size()>k)
                queue.poll();
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int val = queue.poll().getKey();
            list.add(val);
        }
        return list;
    }
}
