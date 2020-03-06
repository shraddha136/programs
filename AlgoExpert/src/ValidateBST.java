public class ValidateBST {
    public static boolean validateBst(BSTConstruction.BST tree) {
        // Write your code here.
        return validate(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean validate(BSTConstruction.BST tree, int minValue, int maxValue) {
        if(tree.value<minValue || tree.value>maxValue)
            return false;

        if(tree.left!=null && !validate(tree.left,minValue,tree.value))
            return false;
        if(tree.right!=null && !validate(tree.right,tree.value,maxValue))
            return false;
        return true;
    }


    public static void main(String[] args) {
        BSTConstruction.BST bst = new BSTConstruction.BST(10);
        bst.insert(5).insert(15).insert(5).insert(2).insert(1).insert(22).insert(35);
//        bst.left.right.right = new BSTConstruction.BST(11);
        System.out.println(ValidateBST.validateBst(bst));
    }
}

