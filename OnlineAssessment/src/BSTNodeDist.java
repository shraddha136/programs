public class BSTNodeDist {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int n) {
            this.val = n;
        }
    }


    private static TreeNode insert(TreeNode node, int n) {
        if (node == null) {
            node = new TreeNode(n);
            return node;
        }
        if (n < node.val) {
            node.left = insert(node.left, n);
        } else {
            node.right = insert(node.right, n);
        }
        return node;
    }

    public int getDist(TreeNode root, int a, int b) {
        return distance(root, a, b);
    }

    private int distance(TreeNode root, int a, int b) {
        if (root == null) {
            return 0;
        }

        if (a < root.val && b < root.val) {
            return distance(root.left, a, b);
        } else if (a > root.val && b > root.val) {
            return distance(root.right, a, b);
        } else {
            return getDepth(root, a) + getDepth(root, b);
        }
    }

    private int getDepth(TreeNode root, int a) {
        if (root.val == a) {
            return 0;
        }
        if (root.val > a) {
            return 1 + getDepth(root.left, a);
        } else {
            return 1 + getDepth(root.right, a);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 8, 7, 9, 3, 11};
        TreeNode root = null;
        for (int n : arr) {
            root = insert(root, n);
        }
        System.out.println(new BSTNodeDist().getDist(root, 2, 11));
    }
}
