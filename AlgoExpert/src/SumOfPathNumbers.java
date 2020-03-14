import java.util.*;


class SumOfPathNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ;

    public static int findSumOfPathNumbers(TreeNode root) {
        // TODO: Write your code here
        int totalSum = 0;
        int sum = 0;


        return getSum(root, sum, totalSum);
    }

    private static int getSum(TreeNode root, int sum, int totalSum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        return getSum(root.left, sum, totalSum)+ getSum(root.right, sum, totalSum);
    }

    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        int i = 0;

        return isPath(root,i,sequence);
    }

    private static boolean isPath(TreeNode root, int i, int[] sequence) {
        if(root == null || root.val != sequence[i])
            return false;
        if(root.left == null && root.right == null && root.val == sequence[i])
            return true;
        return isPath(root.left,i+1,sequence) || isPath(root.right,i+1,sequence);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(0);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(5);
//        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + findPath(root, new int[] { 1, 1, 6 }));
    }
}
