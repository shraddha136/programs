import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobDependency {
    //graph node -> value,children,visited,visiting
    //graph -> map<node,list<nodes>>, addnode to graph, add dependency in graph
    //dependency-> build graph,dfs

    public List<Integer> validJobs(List<Integer> jobs,List<int[]> rules){
        Graph graph = buildGraph(jobs,rules);
        List<Integer> result = getValidOrder(graph);
        return result;
    }

    private List<Integer> getValidOrder(Graph graph) {
        List<Integer> result = new ArrayList<>();
        List<Node> nodeList = graph.nodeList;
        for(Node neighbor:nodeList){
            boolean cycle = dfs(neighbor,result);
            if(cycle)
                return new ArrayList<>();
        }
        return result;
    }

    private boolean dfs(Node node, List<Integer> result) {
        if(node.visited)
            return false;
        if(node.visiting)
            return true;
        node.visiting = true;
        for(Node child:node.preReqList){
            boolean cycle = dfs(child,result);
            if(cycle)
                return true;
        }
        node.visited = true;
        result.add(node.value);
        return false;
    }

    private Graph buildGraph(List<Integer> jobs, List<int[]> rules) {
        Graph graph = new Graph(jobs);
        for(int[] rule: rules){
            int job1 = rule[0];
            int job2 = rule[1];
            graph.addDependency(job1,job2);
        }
        return graph;
    }

    class Graph{
        Map<Integer,Node> graph;
        List<Node> nodeList;
        Graph(List<Integer> numberOfVertices){
            graph = new HashMap<>();
            nodeList = new ArrayList<>();
            for(int i : numberOfVertices){
                addNode(i);
            }
        }

        private void addNode(int vertex) {
            graph.put(vertex,new Node(vertex));
            nodeList.add(graph.get(vertex));
        }

        public void addDependency(int source, int destinaton){
            Node jobNode = graph.get(source);
            Node dependentNode = graph.get(destinaton);
            jobNode.preReqList.add(dependentNode);
        }
    }

    class Node{
        int value;
        List<Node> preReqList;
        boolean visited;
        boolean visiting;

        Node(int value){
            this.value = value;
            this.preReqList = new ArrayList<>();
        }
    }
}
