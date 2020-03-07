public class BST {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }

        public TreeNode insert(TreeNode root, int value) {
            if (root == null)
                root = new TreeNode(value);
            else {
                if (value <= root.value)
                    root.left = insert(root.left, value);
                else
                    root.right = insert(root.right, value);
            }
            return root;
        }
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.insert(node, 2).insert(node,7);
        printTree(node);
    }

    private static void printTree(TreeNode node) {
        if(node==null)
            return;
        printTree(node.left);
        System.out.println(node.value);
        printTree(node.right);
    }

}
