import javafx.scene.control.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NArySerializeDe {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("[");
        if(root.children!=null){
            for (Node child : root.children) {
                sb.append(serialize(child));
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
//    public Node deserialize(String data) {
//        Node root = null;
//        Stack<Node> stack = new Stack<>();
//        int i = 0;
//
//        while (i < data.length()) {
//            int start = i;
//
//            // Move pointer forward until we don't find a digit...
//            while (i < data.length() && Character.isDigit(data.charAt(i))) {
//                i++;
//            }
//
//            // If we haven't found a digit then we must have found the end of a child list...
//            if (start == i) {
//                Node child = stack.pop();
//                if (stack.isEmpty()) {
//                    root = child;
//                    break;
//                } else {
//                    // Remove the child from the stack and assign it to the previous node on the stack
//                    stack.peek().children.add(child);
//                }
//            } else {
//                Node n = new Node();
//                n.val = Integer.parseInt(data.substring(start, i));
//                n.children = new ArrayList<>();
//                stack.push(n);
//            }
//            i++;
//        }
//        return root;
//    }
    public Node deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        Node root = null;
        Stack<Node> stack = new Stack<>();
        int index = 0;
        while(index < data.length()){
            int start = index;
            while(index < data.length() && Character.isDigit(data.charAt(index))){
                index++;
            }

            if(index == start){
                if(!stack.isEmpty()){
                    Node child = stack.pop();
                    if(stack.isEmpty()){
                        root = child;
                        return root;
                    }
                    stack.peek().children.add(child);
                }
            }else{
                Node node = new Node(Integer.valueOf(data.substring(start,index)));
                node.children = new ArrayList<>();
                stack.push(node);
            }
            index++;
        }
        return root;
    }


    // Your NArySerializeDe object will be instantiated and called as such:
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.children = Arrays.asList(three,two,four);
        three.children = Arrays.asList(five,six);
        NArySerializeDe NArySerializeDe = new NArySerializeDe();
        NArySerializeDe.deserialize(NArySerializeDe.serialize(one));
    }

}
