import java.util.*;

public class SumOfPaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        List<Integer> pathValues = new ArrayList<>();
        getPathValues(root, pathValues);

        return getSum(pathValues);
    }

    private int getSum(List<Integer> pathValues) {
        int sum = 0;
        for (int num : pathValues) {
            sum += getBinary(num);
        }
        return sum;
    }

    private int getBinary(int num) {
        int n = 0;
        int i = 0;
        while (num != 0) { // digit * 2 ^ i
            n = n + (num % 10) * (int)Math.pow(2,i++);
            num = num/10;
        }
        return n;
    }

    private void getPathValues(TreeNode root, List<Integer> pathValues) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int num = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left == null && curr.right == null) {
                pathValues.add(curr.val);
            }
            if (curr.left != null) {
                curr.left.val = curr.val * 10 + curr.left.val;
                stack.push(curr.left);
            }
            if (curr.right != null) {
                curr.right.val = curr.val * 10 + curr.right.val;
                stack.push(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(new SumOfPaths().sumRootToLeaf(root));
    }
}
