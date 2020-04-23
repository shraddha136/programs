import java.util.ArrayList;
import java.util.List;


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findSum(root, 0, sum, new ArrayList<>(), result);
        return result;
    }

    private void findSum(TreeNode root, int sumUpto, int sum, List<Integer> list, List<List<Integer>> result) {
        if(root == null)
            return;
        if (root.left == null && root.right == null && sumUpto + root.val == sum) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }else if(root.left == null && root.right == null)
            return;

        list.add(root.val);
        sumUpto += root.val;
        findSum(root.left, sumUpto, sum , list, result);
        findSum(root.right, sumUpto, sum , list, result);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left= new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right = new TreeNode(4);
        node.right.left = new TreeNode(13);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);
        System.out.println(new PathSum2().pathSum(node,13));
    }

}