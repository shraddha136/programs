import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CriticalConnections {
    List<List<Integer>> criticalConnections;
    ArrayList[] graph;
    int[] visitedTimes;
    int[] lowTimes;
    int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        criticalConnections = new ArrayList<>();
        visitedTimes = new int[n];
        lowTimes = new int[n];
        time = 0;

        buildGraph(connections);

        boolean[] visited = new boolean[n];
        dfsTraversal(graph, visited, 0, -1);
        return criticalConnections;
    }

    private void buildGraph(List<List<Integer>> connections) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            int currNode = connection.get(0);
            int partnerNode = connection.get(1);
            graph[currNode].add(partnerNode);
            graph[partnerNode].add(currNode);
        }
    }

    private void dfsTraversal(List<Integer>[] graph, boolean[] visited, int currNode, int parentNode) {
        visited[currNode] = true;
        visitedTimes[currNode] = lowTimes[currNode] = time++;

        for (int neighbour : graph[currNode]) {
            if (neighbour == parentNode) continue;
            if (!visited[neighbour]) {
                dfsTraversal(graph, visited, neighbour, currNode);
                lowTimes[currNode] = Math.min(lowTimes[currNode], lowTimes[neighbour]);
                if (visitedTimes[currNode] < lowTimes[neighbour])
                    criticalConnections.add(Arrays.asList(currNode, neighbour));
            } else {
                lowTimes[currNode] = Math.min(lowTimes[currNode], visitedTimes[neighbour]);
            }
        }
    }

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
        System.out.println(new CriticalConnections().criticalConnections(5, cc));
    }
}











