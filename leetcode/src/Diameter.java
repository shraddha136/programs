/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        getHeight(root);
        return maxDia;
    }

    int maxDia = 0;

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int dia = leftHeight + rightHeight;
        maxDia = Math.max(maxDia, dia);
        return Math.max(leftHeight,rightHeight)+1;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(new Diameter().diameterOfBinaryTree(node));
    }
}