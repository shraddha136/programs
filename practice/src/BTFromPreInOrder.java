import java.util.*;

public class BTFromPreInOrder {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return getTree(preorder,0,inorder,0,inorder.length-1);
    }

    private TreeNode getTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if(inStart>inEnd)
            return null;

        if(inStart == inEnd)
            return new TreeNode(inorder[inEnd]);

        int rootValue = preorder[preStart];
        int inIndex = map.get(rootValue);
        int left = inIndex-inStart;
        int right = inEnd - inIndex;

        TreeNode root = new TreeNode(rootValue);
        root.left = getTree(preorder,preStart+1,inorder,inStart,inIndex-1);
        root.right = getTree(preorder,preStart+left+1,inorder,inIndex+1,inEnd);
        return root;
    }



    static class TreeNode {
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

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        System.out.println(new BTFromPreInOrder().buildTree(pre, in));
    }
}
