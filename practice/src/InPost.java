import java.util.HashMap;
import java.util.Map;

public class InPost {
    private Map<Integer, Integer> inOrderIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }
        return getTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length -1);
    }

    private TreeNode getTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart) {
            return null;
        }
        int rootVal = postOrder[postEnd];
        int inIdx = inOrderIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int remainingStart = inIdx - inStart;
        int remainingEnd = inEnd - inIdx;

        root.left = getTree(inOrder, postOrder, inStart, inIdx - 1, postStart, postStart );
        root.right = getTree(inOrder, postOrder, inIdx + 1, inEnd, postEnd - remainingEnd, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = {3,2,1};
        int[] postOrder = {3,2,1};

        System.out.println(new InPost().buildTree(inOrder,postOrder));
    }
}
