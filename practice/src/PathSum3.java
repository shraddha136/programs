import java.util.*;

public class PathSum3 {

     // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
//        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(1);
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(-2);
//        root.right.right = new TreeNode(11);
        System.out.println(new PathSum3().pathSum(root,-2));

    }
        public int pathSum(TreeNode root, int sum) {
            int count = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0;i<size;i++){
                    TreeNode node = queue.poll();
                    count += hasPath(node,sum);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
            }
            return count;
        }

        private int hasPath(TreeNode node,int target){
            if(node == null || target < 0){
                return 0;
            }
            if(target == node.val){
                return 1;
            }
            return hasPath(node.left,target-node.val) + hasPath(node.right,target-node.val);
        }

}
