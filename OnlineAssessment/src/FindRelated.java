import java.util.*;

public class FindRelated {
    public static void main(String[] args) {
        String[][] products = {{"product1", "product2"}, {"product6", "product7"}};
        System.out.println(findConnected(products));
    }

    private static Set<String> visited;
    private static Map<String, List<String>> graph;

    FindRelated() {

    }

    private static List<String> findConnected(String[][] products) {
        if (products.length == 0) {
            return new ArrayList<>();
        }
        graph = buildGraph(products);
        visited = new HashSet<>();
        int maxSize = 0;
        List<String> result = new ArrayList<>();
        for (String key : graph.keySet()) {
            if (!visited.contains(key)) {
                List<String> current = performDFS(graph, key);
                if (result.size() == current.size()) {
                    if (isGreater(result, current)) {
                        result = current;
                    }
                } else if (result.size() < current.size()) {
                    result = current;
                }
            }

        }
        return result;
    }

    private static boolean isGreater(List<String> result, List<String> current) {
        int i = 0;
        int j = 0;
        while (i < result.size()) {
            if (result.get(i++).compareTo(current.get(j++)) < 0) {
                return false;
            }
        }
        return true;
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

    private static List<String> performDFS(Map<String, List<String>> graph, String start) {
        Stack<String> stack = new Stack<>();
        stack.push(start);
        int size = 1;
        List<String> result = new ArrayList<>();
        result.add(start);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            visited.add(current);
            for (String child : graph.get(current)) {
                if (!visited.contains(child)) {
                    size++;
                    result.add(child);
                    stack.push(child);
                }
            }
        }
        return result;
    }

    private static Map<String, List<String>> buildGraph(String[][] products) {
        Map<String, List<String>> graph = new LinkedHashMap<>();
        int count = 0;
        for (String[] product : products) {
            for (int j = 0; j < product.length - 1; j++) {
                ++count;

                graph.putIfAbsent(product[j], new ArrayList<>());
                graph.get(product[j]).add(product[j + 1]);
                graph.putIfAbsent(product[j + 1], new ArrayList<>());
                graph.get(product[j + 1]).add(product[j]);
            }
        }
        System.out.println(count);
        return graph;
    }

}
