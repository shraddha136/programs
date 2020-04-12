/*
import javax.xml.soap.Node;
import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        MyGraph graph = createGraph(vertices, edges);
        sortedOrder = getSortedOrder(graph);
        return sortedOrder;
    }

    private static MyGraph createGraph(int vertices, int[][] edges) {
        MyGraph graph = new MyGraph(vertices);
        for (int[] edge : edges) {
            int pre = edge[0];
            int post = edge[1];
            graph.addDependency(pre, post);
        }
        return graph;
    }

    private static List<Integer> getSortedOrder(MyGraph graph) {
        List<Integer> result = new ArrayList<>();

        for (Nodes node : graph.nodesList) {
            boolean isCycle = traverse(node, result);
            if (isCycle)
                return new ArrayList<>();
        }
        return result;
    }

    private static boolean traverse(Nodes node, List<Integer> result) {
        if (node.visited)
            return false;
        if (node.visiting)
            return true;
        node.visiting = true;
        for (Nodes preNodes : node.edges) {
            boolean isCycle = traverse(preNodes, result);
            if (isCycle)
                return true;
        }
        node.visited = true;
        result.add(node.vertex);
        return false;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
                new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        System.out.println(result);
    }

    private static class MyGraph {
        List<Nodes> nodesList;
        Map<Integer, Nodes> graph;

        MyGraph(int vertices) {
            nodesList = new ArrayList<>();
            graph = new HashMap<>();
            for (int i = 0; i < vertices; i++) {
                addNode(i);
            }
        }

        private void addNode(int i) {
            Nodes node = new Nodes(i);
            graph.put(i, node);
            nodesList.add(graph.get(i));
        }

        public void addDependency(int pre, int post) {
            Nodes preNode = graph.get(pre);
            Nodes postNode = graph.get(post);
            postNode.edges.add(preNode);
        }
    }

    private static class Nodes {
        int vertex;
        List<Nodes> edges;
        boolean visited;
        boolean visiting;

        Nodes(int vertex) {
            this.vertex = vertex;
            this.edges = new ArrayList<>();
            visited = false;
            visiting = false;
        }
    }
}*/
