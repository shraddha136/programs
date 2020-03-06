import java.util.LinkedList;
import java.util.Queue;

public class InvertBST {
    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if(tree==null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(tree);

    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left= new BinaryTree(2);
        tree.right= new BinaryTree(3);
        tree.left.left= new BinaryTree(4);
        tree.left.right= new BinaryTree(5);
        tree.right.left= new BinaryTree(6);
        tree.right.right= new BinaryTree(7);
        invertBinaryTree(tree);
    }
}

