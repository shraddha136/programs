import java.util.*;

public class KNeighbors {
    /**
     * Definition for a binary tree node.
     *
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, TreeNode> childToParentMapping = new HashMap<>();


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        getMapping(root, null);
        return performBFS(target, K);
    }

    private void getMapping(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        childToParentMapping.put(root, parent);
        getMapping(root.left, root);
        getMapping(root.right, root);
    }

    private List<Integer> performBFS(TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            result.add(target.val);
            return result;
        }
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                set.add(node);
                if (node.left != null && !set.contains(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && !set.contains(node.right)) {
                    queue.offer(node.right);
                }
                TreeNode parent = childToParentMapping.get(node);
                if (parent != null && !set.contains(parent)) {
                    queue.offer(childToParentMapping.get(node));
                }
            }
            currentLevel++;
            if (currentLevel == k) {
                break;
            }
        }
        while (queue.size() > 0) {
            result.add(queue.poll().val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new KNeighbors().distanceK(root,root.left,3));
    }
}

