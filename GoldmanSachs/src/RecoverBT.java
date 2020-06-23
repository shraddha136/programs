import java.util.Stack;

public class RecoverBT {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);
//        root.right.right.left = new Node(5);
//        root.right.right.right = new Node(10);
//        regularInOrder(root);
        System.out.println();
        iterativeInOrder(root);
    }

    private static void iterativeInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node prev = null, x = null, y = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && root.val < prev.val){
                y = root;
                if(x == null){
                    x = prev;
                }else
                    break;
            }
            prev = root;
            root = root.right;
        }
        swap(x,y);
    }

    private static void swap(Node x, Node y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    private static void regularInOrder(Node root) {
        if (root == null)
            return;
        regularInOrder(root.left);
        System.out.print(root.val);
        regularInOrder(root.right);
    }
}
