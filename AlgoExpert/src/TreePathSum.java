import java.util.ArrayList;
import java.util.List;

class TreePathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ;

    public static boolean hasPath(TreeNode root, int sum) {
        // TODO: Write your code here

        return sum(root, sum);
    }

    private static boolean sum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;

        return sum(root.left, sum - root.val) || sum(root.right, sum - root.val);
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        // TODO: Write your code here

        path(root, sum, new ArrayList<Integer>(), allPaths);
        return allPaths;
    }

    private static void path(TreeNode root, int sum, ArrayList<Integer> currPath, List<List<Integer>> allPaths) {
        if (root == null)
            return;
        currPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            allPaths.add(new ArrayList<>(currPath));
        }
        path(root.left, sum - root.val, currPath, allPaths);
        path(root.right, sum - root.val, currPath, allPaths);
        currPath.remove(currPath.size() - 1);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(12);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(9);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(5);
//        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
//        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
