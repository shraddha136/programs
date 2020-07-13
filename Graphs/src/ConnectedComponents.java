import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConnectedComponents {
    boolean[] visited;

    public int getConnecteComponents(List<Node> graph, int n) {
        visited = new boolean[n];
        int count = 0;
        for (Node node : graph) {
            if (!visited[node.name]) {
                performDFS(node);
                count++;
            }
        }
        return count;
    }

    public void performDFS(Node start) {
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        visited[start.name] = true;
        while (!stack.isEmpty()) {
            Node current = stack.pop();
//            System.out.println(current.name);
            for (Node neighbor : current.children) {
                if (!visited[neighbor.name]) {
                    stack.push(neighbor);
                    visited[neighbor.name] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node Z = new Node(0);
        Node A = new Node(1);
        Node B = new Node(2);
//        Node C = new Node(3);
//        Node D = new Node(4);
//        Node E = new Node(5);
//        Node F = new Node(6);
        graph.addNode(Z);
        graph.addNode(A);


        graph.addNode(B);
//        graph.addNode(C);
//        graph.addNode(D);
//        graph.addNode(E);
//        graph.addNode(F);
        Z.addChildren(A);
//        Z.addChildren(B);
        A.addChildren(Z);
        A.addChildren(B);
        B.addChildren(A);
//        B.addChildren(Z);
//        Z.addChildren(B);
//        A.addChildren(Z);
//        A.addChildren(C);
//        C.addChildren(A);
//        B.addChildren(Z);
//        D.addChildren(E);
//        E.addChildren(F);
//        E.addChildren(D);
//        E.addChildren(B);
//        B.addChildren(E);
//        System.out.println(new ConnectedComponents().getConnecteComponents(graph.graph, 7));
//        System.out.println(new ConnectedComponents().canReach(graph,Z, F));
        System.out.println(new ConnectedComponents().cycleExists(graph));
    }

    int n;

    private boolean cycleExists(Graph graph) {
        visited = new boolean[graph.graph.size()];
        for (Node node : graph.graph) {
            if(!visited[node.name]) {
                if (dfs(node, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(Node node, Node parent) {
        visited[node.name] = true;
        for (Node child : node.children) {
            if (!visited[child.name]) {
                dfs(child, node);
            } else if ( child != parent) {
                return true;
            }
        }
        return false;
    }

    public ConnectedComponents() {
        boolean[] visited;

    }

    private boolean canReach(Graph graph, Node z, Node f) {
        visited = new boolean[graph.graph.size()];
        performDFS(z);
        return visited[f.name];
    }

    private static class Graph {
        List<Node> graph;

        public Graph() {
            graph = new ArrayList<>();
        }

        public void addNode(Node node) {
            graph.add(node);
        }
    }

    private static class Node {
        int name;
        List<Node> children;

        Node(int name) {
            this.name = name;
            children = new ArrayList<>();
        }

        public void addChildren(Node node) {
            children.add(node);
        }

    }
}
