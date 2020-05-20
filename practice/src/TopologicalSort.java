import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here

        MyGraph graph = createGraph(vertices,edges);
        sortedOrder = getSortedOrder(graph);
        return sortedOrder;
    }

    private static MyGraph createGraph(int vertices, int[][] edges) {
        MyGraph myGraph = new MyGraph(vertices);
        for(int[] edge:edges){
            int pre = edge[0];
            int post = edge[1];
            myGraph.addDependency(pre,post);
        }
        return myGraph;
    }

    private static List<Integer> getSortedOrder(MyGraph graph) {
        List<Integer> result = new ArrayList<>();

        for(Node node:graph.nodeList){
            boolean isCycle = dfs(node,result);
            if(isCycle)
                return new ArrayList<>();
        }
        return result;
    }

    private static boolean dfs(Node node,List<Integer> result) {
        if(node.visited)
            return false;
        if(node.visiting)
            return true;
        node.visiting = true;

        for(Node edge:node.edges){
            boolean isCycle = dfs(edge,result);
            if(isCycle)
                return true;
        }
        node.visited = true;
        result.add(node.value);
        return false;

    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 1,0 }, new int[] { 0, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}

class MyGraph{
    List<Node> nodeList;
    Map<Integer,Node> graph;

    public MyGraph(int vertices) {
        nodeList = new ArrayList<>();
        graph = new HashMap<>();
        for(int i = 0;i<vertices;i++){
            addNode(i);
        }
    }

    private void addNode(int i) {
        Node node = new Node(i);
        graph.put(i,node);
        nodeList.add(graph.get(i));
    }

    public void addDependency(int pre, int post) {
        Node preNode = graph.get(pre);
        Node postNode = graph.get(post);
        preNode.edges.add(postNode);

    }
}

class Node{
    int value;
    List<Node> edges;
    boolean visited;
    boolean visiting;

    Node(int vertex){
        this.value = vertex;
        this.edges = new ArrayList<>();
        visited = false;
        visiting = false;
    }
}