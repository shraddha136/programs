import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigZagTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean right = false;
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<=n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                if(right)
                    list.add(0,node.val);
                else
                    list.add(node.val);
            }
            right = !right;
            result.add(list);
        }
        return result;
    }
}
