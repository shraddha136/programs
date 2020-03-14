

class TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };
    public static int findDiameter(TreeNode root) {
        // TODO: Write your code here
        if(root == null)
            return 0;
         getDiameter(root);
         return maxDia;
    }

    private static int maxDia = Integer.MIN_VALUE;
    private static int getDiameter(TreeNode root) {
        if(root==null)
            return 0;
        int lht = getDiameter(root.left);
        int rht = getDiameter(root.right);
        int dia = 1 + lht + rht;

        maxDia = Math.max(dia,maxDia);
        return 1 + Math.max(getDiameter(root.left),getDiameter(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
