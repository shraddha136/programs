import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MAxWidth {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Pair<TreeNode,Integer>> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                list.add(pair);
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if(node.left != null){
                    queue.offer(new Pair<>(node.left,2*index+1));
                }
                if(node.right != null){
                    queue.offer(new Pair<>(node.right,2*index+2));
                }
            }
            maxWidth = Math.max(maxWidth,list.get(list.size()-1).getValue()-list.get(0).getValue()+1);
        }
        return maxWidth;
    }
}

