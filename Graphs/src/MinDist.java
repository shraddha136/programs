import java.util.*;

public class MinDist {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addNeighbor(0, 1);
        graph.addNeighbor(0, 3);
        graph.addNeighbor(1, 2);
        graph.addNeighbor(2, 4);
        graph.addNeighbor(3, 4);
        graph.addNeighbor(4, 5);
        System.out.println(getMinDist(0, 5, graph));
    }

    private static int getMinDist(int start, int end, Graph graph) {
        Queue<Node> queue = new LinkedList<>();
        Node startNode = graph.nodeMap.get(start);
        startNode.visited = true;
        queue.offer(startNode);
        int minDist = 0;

        Node endNode = graph.nodeMap.get(end);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                for (Node neighbor : curr.neighbors) {
                    if (!neighbor.visited) {

                        if (neighbor == endNode) {
                            return minDist;
                        }
                        queue.offer(neighbor);
                        neighbor.visited = true;
                    }
                }
            }
            minDist++;

        }
        return -1;
    }

    static class Node {
        int val;
        List<Node> neighbors;
        boolean visiting;
        boolean visited;
//        int dist;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
            visited = false;
            visiting = false;
//            dist = 100001;
        }
    }

    static class Graph {
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
            nodeMap.get(dest).neighbors.add(nodeMap.get(src));
        }
    }
}

