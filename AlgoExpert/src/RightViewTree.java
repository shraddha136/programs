import java.util.*;


class RightViewTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        // TODO: Write your code here
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<TreeNode>> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<TreeNode> level = new ArrayList<>();
            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();
                level.add(node);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            list.add(level);
        }

        for(int i = 0;i<list.size();i++)
            result.add(list.get(i).get(0));
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}

