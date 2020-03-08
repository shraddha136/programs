/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        if (s == null)
            return false;


        return isSame(s, t) || isSubtree(s.left,t.left) || isSubtree(s.right,t.right);

    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        if (s == null)
            return false;
        return (s.val==t.val) && isSame(s.left,t.left) && isSame(s.right,t.right);
    }


    public static void main(String[] args) {

    }
}