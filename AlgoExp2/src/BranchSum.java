import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();

        return getSum(root, result, 0);

    }

    private static List<Integer> getSum(BinaryTree root, List<Integer> result, int sum) {
        if(root==null)
            return new ArrayList<>();
        sum += root.value;

        if (root.left == null && root.right == null) {
            result.add(sum);
            return result;
        }
        if (root.left != null)
            getSum(root.left, result, sum);
        if (root.right != null)
            getSum(root.right, result, sum);
        return result;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        System.out.println(branchSums(tree));
    }
}
