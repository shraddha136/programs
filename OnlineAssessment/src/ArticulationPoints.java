import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArticulationPoints {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(0);
        List<Integer> l4 = new ArrayList<>();
        l4.add(0);
        l4.add(3);
        List<Integer> l5 = new ArrayList<>();
        l5.add(3);
        l5.add(4);
        List<List<Integer>> cc = new ArrayList<>();
        cc.add(l1);
        cc.add(l2);
        cc.add(l3);
        cc.add(l4);
        cc.add(l5);

        System.out.println(new ArticulationPoints().getAT(cc, 5));
    }

    int[][] graph;
    List<Integer> result = new ArrayList<>();

    private List<Integer> getAT(List<List<Integer>> connections, int n) {
        if (n <= 1 || connections == null)
            return result;
        graph = new int[n][n];
        buildGraph(connections);
        for (int i = 0; i < n; i++) {
            performAllDFS(i, n);
        }
        return result;
    }

    private int[][] getGraph(int vertex, int n) {
        int[][] currentGraph = graph;
        for (int i = 0; i < n; i++) {
            currentGraph[vertex][i] = 0;
        }
        return currentGraph;
    }

    private void performAllDFS(int vertex, int n) {
        int[][] currentGraph = getGraph(vertex, n);

        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        List<Integer> currDFS = new ArrayList<>();
        while (!stack.isEmpty()) {
            int currVertex = stack.pop();
            if (!visited[currVertex]) {
                visited[vertex] = true;
                currDFS.add(vertex);
                for (int i = 0; i < currentGraph.length; i++) {
                    if (currentGraph[vertex][i] == 1)
                        stack.push(i);
                }
            }
        }
        if (currDFS.size() < currentGraph.length)
            result.add(vertex);
    }

    private void buildGraph(List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
    }
}
