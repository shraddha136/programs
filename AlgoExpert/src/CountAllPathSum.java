import java.util.*;


class CountAllPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };
    public static int countPaths(TreeNode root, int S) {
        // TODO: Write your code here
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
         findPath(root,S,currPath,allPaths);

        return allPaths.size();
    }

    private static void findPath(TreeNode root, int s, List<Integer> currPath, List<List<Integer>> allPaths) {
        if(root == null)
            return;
        currPath.add(root.val);
        if(root.val == s)
            allPaths.add(new ArrayList<>(currPath));
        findPath(root.left,s-root.val,currPath,allPaths);
        findPath(root.right,s-root.val,currPath,allPaths);
        currPath.remove(currPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
