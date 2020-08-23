import java.util.*;

public class FrogJump {
    //    public boolean canCross(int[] stones) {
//        Set<Integer> stonePos = new HashSet<>();
//        for(int stone: stones){
//            stonePos.add(stone);
//        }
//
//        Stack<Integer> positions = new Stack<>();
//        Stack<Integer> jumps = new Stack<>();
//        positions.add(0);
//        jumps.add(0);
//        int count = 0;
//        while(!positions.isEmpty()){
//            int pos = positions.pop();
//            int jump = jumps.pop();
//
//            for(int i = jump-1;i<=jump+1;i++){
//                count++;
//
//                if(i <= 0){
//                    continue;
//                }
//                int newPos = pos + i;
//                if(newPos == stones[stones.length-1]){
//                    System.out.println(count);
//                    return true;
//                }
//                if(stonePos.contains(newPos)){
//                    positions.push(newPos);
//                    jumps.push(i);
//                }
//
//            }
//        }
//        System.out.println(count);
//        return false;
//    }
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(0).add(0);
        int end = stones[stones.length - 1];

        for (int key : stones) {
            for (int j : map.get(key)) {
                for (int i = j - 1; i <= j + 1; i++) {
                    if (map.containsKey(key + i)) {
                        map.get(key + i).add(i);
                    }
                    if (key + i == end) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        int[] stone = {0,2};
        int[] stone = {0, 1, 3, 6, 10, 15, 21, 28};
        System.out.println(new FrogJump().canCross(stone));
//        System.out.println(new FrogJump().canCross2(stone));
    }
//    public boolean canCross2(int[] stones) {
//        if(stones == null || stones.length == 0){
//            return true;
//        }
//        int end = stones[stones.length-1];
//
//        Map<Integer,Set<Integer>> jumpMap = new HashMap<>();
//        for (int stone : stones) {
//            jumpMap.put(stone, new HashSet<>());
//        }
//
//        jumpMap.get(0).add(0);
//
//        for (int currentStone : stones) {
//            Set<Integer> jumps = jumpMap.get(currentStone);
//            for (int jump : jumps) {
//                for (int hop = jump - 1; hop <= jump + 1; hop++) {
//                    if(currentStone + hop == end){
//                        return true;
//                    }
//                    if (hop>0 && jumpMap.containsKey(currentStone + hop)) {
//                        jumpMap.get(currentStone + hop).add(hop);
//                    }
//                }
//            }
//        }
//        return false;
//    }


//    private boolean canCross2(int[] stone) { //O(n^2)
//        Map<Integer,Set<Integer>> jumpMap = new HashMap<>();
//        for(int val : stone){
//            jumpMap.put(val, new HashSet<>());
//        }
//        jumpMap.get(0).add(0);
//
//        for (int currentPos : stone) {
//            for (int jump : jumpMap.get(currentPos)) {
//                for (int step = jump - 1; step <= jump + 1; step++) {
//                    if (step > 0 && jumpMap.containsKey(currentPos + step)) {
//                        jumpMap.get(currentPos + step).add(step);
//                        if (currentPos + step == stone[stone.length - 1]) {
//                            return true;
//                        }
//                    }
//                }
//
//            }
//        }
//        return false;
//    }
}
