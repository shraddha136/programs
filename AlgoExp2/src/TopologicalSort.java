import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopologicalSort {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.
        Graph graph = createGraph(jobs,deps);
        return orderGraph(graph);
    }

    private static Graph createGraph(List<Integer> jobs, List<Integer[]> deps) {
        Graph graph = new Graph(jobs);
        for(Integer[] dep:deps){
            int preReq = dep[0];
            int job = dep[1];
            graph.addPreReqNode(job,preReq);
        }
        return graph;
    }

    private static List<Integer> orderGraph(Graph graph) {
        List<Integer> result = new ArrayList<>();
        List<Node> nodes = graph.nodeList;
        for (Node node : nodes) {
            boolean isCycle = dfsTrav(node, result);
            if (isCycle)
                return new ArrayList<>();
        }
        return result;
    }

    private static boolean dfsTrav(Node node, List<Integer> result) {
        if (node.visited)
            return false;
        if (node.visiting)
            return true;

        node.visiting = true;
        for (Node preReqNode : node.preReqList) {
            boolean isCycle = dfsTrav(preReqNode,result);
            if(isCycle)
                return true;
        }
        node.visited = true;
        result.add(node.job);
        return false;
    }

    static class Graph {
        List<Node> nodeList;
        HashMap<Integer,Node> graph;

        public Graph(List<Integer> jobs) {
            nodeList = new ArrayList<>();
            graph = new HashMap<>();
            for (int n : jobs)
                addNode(n);
        }

        private void addPreReqNode(int job, int preReq){
            Node jobNode = graph.get(job);
            Node preReqNode = graph.get(preReq);
            jobNode.preReqList.add(preReqNode);
        }

        private void addNode(int n) {
            graph.put(n,new Node(n));
            nodeList.add(graph.get(n));
        }

        private Node getNode(int job){
            if(!graph.containsKey(job))
                addNode(job);
            return graph.get(job);
        }
    }

    static class Node {
        int job;
        List<Node> preReqList;
        boolean visited;
        boolean visiting;

        public Node(int job) {
            this.job = job;
            preReqList = new ArrayList<>();
            visited = false;
            visiting = false;
        }
    }
}
