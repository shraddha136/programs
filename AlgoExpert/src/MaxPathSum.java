public class MaxPathSum {
    static class Sum {
        int runningMaxSum;
        int maxSumAsBranch;

        public Sum() {
            runningMaxSum = 0;
            maxSumAsBranch = 0;
        }

        public Sum getMax(Sum a, Sum b) {
            return a.maxSumAsBranch > b.maxSumAsBranch ? a : b;
        }
    }

    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        Sum sum = getSum(tree);
        return sum.runningMaxSum;
    }

    private static Sum getSum(BinaryTree root) {
        if (root == null)
            return new Sum();
        Sum lefty = getSum(root.left);
        Sum righty = getSum(root.right);

        int maxChildSumAsBranch = new Sum().getMax(lefty, righty).maxSumAsBranch;
        int value = root.value;

        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        int maxSumAsRoot = Math.max(maxSumAsBranch, lefty.maxSumAsBranch + value + righty.maxSumAsBranch);
        int maxPathSum = Math.max(Math.max(lefty.runningMaxSum, righty.runningMaxSum), maxSumAsRoot);

        Sum sum = new Sum();
        sum.maxSumAsBranch = maxSumAsBranch;
        sum.runningMaxSum = maxPathSum;
        return sum;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        System.out.println("Maximum Path Sum: " + maxPathSum(root));

        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(3);
        root.right.left = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.right.left.left = new BinaryTree(7);
        root.right.left.right = new BinaryTree(8);
        root.right.right.left = new BinaryTree(9);
        System.out.println("Maximum Path Sum: " + maxPathSum(root));

        root = new BinaryTree(-1);
        root.left = new BinaryTree(-3);
        System.out.println("Maximum Path Sum: " + maxPathSum(root));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
