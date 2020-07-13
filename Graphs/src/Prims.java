import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 12);
        graph.addEdge(3, 2, 8);

        System.out.println(new Prims().getMinDist(0, 4, graph));
    }

    boolean[] visited;

    public int getMinDist(int src, int dest, Graph graph) {
        visited = graph.visited;
        if (src == dest) {
            return 0;
        }
        int minCost = 0;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Edge(src, 0));
        while (!minHeap.isEmpty()) {
            Edge edge1 = minHeap.poll();
            int currNode = edge1.dest;

            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            minCost += edge1.weight;

            for (Edge edge : graph.graph.get(currNode)) {
                if (!visited[edge.dest]) {
                    minHeap.offer(edge);
                }
            }
        }
        return minCost;

    }

    static class Graph {
        List<List<Edge>> graph;
        boolean[] visited;

        Graph(int n) {
            graph = new ArrayList<>();
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                graph.add(i, new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest, int w) {
            graph.get(src).add(new Edge(dest, w));
            graph.get(dest).add(new Edge(src, w));
        }
    }

    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int w) {
            this.dest = dest;
            this.weight = w;
        }
    }
}
