import java.util.*;

public class BSTVerticalTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        nodes.offer(root);
        columns.offer(0);
        int min = 0;
        int max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int col = columns.poll();
            List<Integer> list = map.get(col);
            if (list == null)
                list = new ArrayList<>();
            list.add(node.val);
            map.put(col, list);
            if (node.left!=null){
                nodes.offer(node.left);
                columns.offer(col-1);
                min = Math.min(min,col-1);
            }
            if (node.right!=null){
                nodes.offer(node.right);
                columns.offer(col+1);
                max = Math.max(max,col+1);
            }
        }

        for(int i = min;i<=max;i++){
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(new BSTVerticalTraversal().verticalOrder(node));
    }
}
