import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topo {
    private static boolean[] visited;

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addNeighbor(0, 1);
        graph.addNeighbor(1, 2);
        graph.addNeighbor(2, 3);
        graph.addNeighbor(3, 0);
        System.out.println(getOrder(graph));
    }

    private static List<Integer> getOrder(Graph graph) {
        List<Integer> result = new ArrayList<>();
        for (Node node : graph.nodeList) {
            if (dfs(node, result)) {
                return new ArrayList<>();
            }

        }
        return result;
    }

    private static boolean dfs(Node node, List<Integer> result) {
        if (node.visited) {
            return false;
        }
        if (node.visiting) {
            return true;
        }
        node.visiting = true;
        for (Node neighbor : node.neighbors) {
            if (dfs(neighbor, result)) {
                return true;
            }
        }
        node.visited = true;
        result.add(node.val);
        return false;
    }
}

class Node {
    int val;
    List<Node> neighbors;
    boolean visiting;
    boolean visited;

    Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
        visited = false;
        visiting = false;
    }
}

class Graph {
    List<Node> nodeList;
    Map<Integer, Node> nodeMap;

    Graph(int n) {
        nodeMap = new HashMap<>();
        nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            nodeList.add(node);
            nodeMap.put(i, node);
        }
    }

    public void addNeighbor(int src, int dest) {
        nodeMap.get(src).neighbors.add(nodeMap.get(dest));
    }
}