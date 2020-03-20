public class FindClosestValueInBst {
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        if (tree == null)
            return -1;
        findClosest(tree, target);
        return closest;
    }

    static int minDiff = Integer.MAX_VALUE;
    static int closest = -1;

    private static void findClosest(BST curr, int target) {
        BST root = curr;
        while (root != null) {
            int diff = Math.abs(target - root.value);
            if (diff < minDiff) {
                minDiff = diff;
                closest = root.value;
            }
            if (target < root.value) {

                if (root.left != null)
                    root = root.left;
            } else if (target >= root.value) {

                if (root.right != null)
                    root = root.right;
            } else
                break;
        }


    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
