import java.util.*;

class BFS {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            System.out.println(this.name);
            while(!queue.isEmpty()){
                Node current = queue.poll();
                array.add(current.name);
                for(Node child:current.children){
                    queue.offer(child);
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
