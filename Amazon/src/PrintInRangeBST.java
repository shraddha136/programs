public class PrintInRangeBST {
    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node root;

    public static void main(String[] args) {
        PrintInRangeBST tree = new PrintInRangeBST();
        int k1 = 10, k2 = 25;
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);

        tree.Print(root, k1, k2);
    }

    private void Print(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        Print(root.left, k1, k2);
        if (k1 <= root.data && root.data <= k2) {
            System.out.println(root.data);
        }
        Print(root.right, k1, k2);
    }
}
