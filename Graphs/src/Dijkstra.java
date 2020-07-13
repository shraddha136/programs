import javafx.util.Pair;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 3, 8);
        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 9);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 7);
        graph.addEdge(3, 2, 2);
        graph.addEdge(4, 1, 5);
        System.out.println(new Dijkstra().getMinDist(0, 4, graph));
    }

    int[] distance;
    boolean[] visited;

    public int getMinDist(int src, int dest, Graph graph) {
        visited = graph.visited;
        distance = graph.distance;
        if (src == dest) {
            return 0;
        }
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Edge(src, 0));
        distance[src] = 0;
        while (!minHeap.isEmpty()) {
            int currNode = minHeap.poll().dest;

            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;

            int currDist = distance[currNode];

            for (Edge edge : graph.graph.get(currNode)) {
                if (currDist + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = currDist + edge.weight;
                    edge.weight = currDist + edge.weight;
                    minHeap.offer(edge);
                }
            }
        }
        return distance[dest];

    }

    static class Graph {
        List<List<Edge>> graph;
        boolean[] visited;
        int[] distance;

        Graph(int n) {
            graph = new ArrayList<>();
            visited = new boolean[n];
            distance = new int[n];
            for (int i = 0; i < n; i++) {
                graph.add(i, new ArrayList<>());
                distance[i] = Integer.MAX_VALUE;
            }
        }

        public void addEdge(int src, int dest, int w) {
            graph.get(src).add(new Edge(dest, w));
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
