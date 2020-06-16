import java.util.*;

public class CheapPrice {
    Map<Integer, List<int[]>> map = new HashMap<>();
    private int minDist = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 0) {
            return 0;
        }
        buildMatrix(flights);
        int dist = bfs(flights, src, dst, K);
        dfs( src, dst, K + 1, 0);
        return minDist;
    }

    private void dfs( int src, int dst, int k, int currCost) {
        if (k < 0) {
            return;
        }
        if(src == dst){
            minDist = currCost;
            return;
        }
        if(!map.containsKey(src)){
            return;
        }
        for(int[] neighbor:map.get(src)){
            if(currCost+neighbor[1]>minDist){
                continue;
            }
            dfs(neighbor[0],dst,k-1,currCost+neighbor[1]);
        }
    }

    private int bfs(int[][] flights, int src, int dst, int K) {
        int minCost = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        int stops = 0;
        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == dst) {
                    minCost = Math.min(minCost, curr[1]);
                }
                if (!map.containsKey(curr[0])) {
                    continue;
                }
                for (int[] cities : map.get(curr[0])) {
                    if (curr[1] + cities[1] > minCost) {
                        continue;
                    }
                    queue.add(new int[]{cities[0], curr[1] + cities[1]});
                }
            }
            if (stops++ > K) {
                break;
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }


    private void buildMatrix(int[][] flights) {

        for (int[] flight : flights) {
            int node = flight[0];
            List<int[]> list = new ArrayList<>();
            if (map.containsKey(node)) {
                list = map.get(node);
            }
            int[] adj = new int[2];
            adj[0] = flight[1];
            adj[1] = flight[2];
            list.add(adj);
            map.put(node, list);
        }

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(new CheapPrice().findCheapestPrice(3, grid, 0, 2, 1));
    }

}
