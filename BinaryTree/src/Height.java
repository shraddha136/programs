public class Height {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    private static int getHeight(Node root){
        if(root == null)
            return -1;
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.left.right.left = new Node(10);
        root.right.right.left.left = new Node(11);
        printNode(root);
    }

    private static void printNode(Node root) {
        if(root == null)
            return;
        System.out.println(root.val);
        printNode(root.left);
        printNode(root.right);
    }


}
