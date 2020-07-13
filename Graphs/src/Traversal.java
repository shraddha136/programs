import java.util.*;

public class Traversal {
    static class Node {
        String name;
        List<Node> neighbors;
        boolean visited;

        Node(String name) {
            this.name = name;
            neighbors = new ArrayList<>();
        }

        void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
        }
    }


    public void performDFS(Node start) {
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        start.visited = true;
        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.println(current.name);
            for(Node neighbor: current.neighbors){
                if(!neighbor.visited){
                    stack.push(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }
    public void performBFS(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        start.visited = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            current.visited = true;
            System.out.println(current.name);
            for (Node neighbor : current.neighbors) {
                if (!neighbor.visited) {
                    queue.offer(neighbor);
                    neighbor.visited = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        A.neighbors.add(B);
        A.neighbors.add(D);
        B.neighbors.add(C);
        B.neighbors.add(A);
        B.neighbors.add(D);
        C.neighbors.add(B);
        D.neighbors.add(A);
        D.neighbors.add(B);
        D.neighbors.add(E);
        E.neighbors.add(D);
        E.neighbors.add(F);
        F.neighbors.add(E);
//        new Traversal().performBFS(A);
        new Traversal().performDFS(A);

    }

}
