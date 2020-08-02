import java.util.*;

public class FindRelated {
    public static void main(String[] args) {
        String[][] products = {{"product1", "product2", "product3"}, {"product5", "product2"}, {"product6", "product7"}, {"product8", "product7"}};
        System.out.println(findConnected(products));
    }

    private static boolean[] visited;
    private static Map<Integer, List<Integer>> graph;
    private static Map<String, Integer> nameToIdMap;
    FindRelated(){

    }
    private static int findConnected(String[][] products) {
        if (products.length == 0) {
            return 0;
        }
        nameToIdMap = getMap(products);
        graph = buildGraph(nameToIdMap, products);
        visited = new boolean[graph.size()];
        int maxSize = 0;
        for (int key : graph.keySet()) {
            maxSize = Math.max(performDFS(graph, key), maxSize);
        }
        return maxSize;
    }

    private static Map<String, Integer> getMap(String[][] products) {
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (String[] product : products) {
            for (int j = 0; j < product.length; j++) {
                if (!map.containsKey(product[j])) {
                    map.put(product[j], id++);
                }
            }
        }
        return map;
    }

    private static int performDFS(Map<Integer, List<Integer>> graph, int start) {
       Stack<Integer> stack = new Stack<>();
       stack.push(start);
       int size = 1;
       while(!stack.isEmpty()){
           int current = stack.pop();
           visited[current] = true;
           for(int child : graph.get(current)){
               if(!visited[child]){
                   size++;
                   stack.push(child);
               }
           }
       }
       return size;
    }

    private static Map<Integer, List<Integer>> buildGraph(Map<String, Integer> nameToIdMap, String[][] products) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int count = 0;
        for (String[] product : products) {
            for (int j = 0; j < product.length - 1; j++) {
                ++count;
                int p1 = nameToIdMap.get(product[j]);
                int p2 = nameToIdMap.get(product[j + 1]);
                graph.putIfAbsent(p1, new ArrayList<>());
                graph.get(p1).add(p2);
                graph.putIfAbsent(p2, new ArrayList<>());
                graph.get(p2).add(p1);
            }
        }
        System.out.println(count);
        return graph;
    }

}
