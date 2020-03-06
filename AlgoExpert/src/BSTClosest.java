public class BSTClosest {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        int closest = Integer.MAX_VALUE;
        closest = findClosest(tree,target,closest);
        System.out.println(closest);
        return closest;
    }

    private static int findClosest(BST root,int target, int closest){
        if(root == null)
            return closest;
        if(target==root.value)
            return root.value;
        else if(target<root.value){
            closest = Math.min(root.value,closest);
            return findClosest(root.left,target,closest);
        }else{
            closest = Math.min(root.value,closest);
            return findClosest(root.right,target,closest);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(10);
//        bst.
    }
}
