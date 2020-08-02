import java.util.*;

public class MaxAverageSubtree {
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
    public class TreeNode {
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

//    public double maximumAverageSubtree(TreeNode root) {
//        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            List<Integer> currList = new ArrayList<>();
//
//            if (node.left != null) {
//                queue.offer(node.left);
//                currList.add(node.left.val);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//                currList.add(node.right.val);
//            }
//            map.put(node.val, currList);
//        }
//        double maxAvg = 0.0;
//
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//
//            int sum = entry.getKey();
//            int count = 1;
//            for (int val : entry.getValue()) {
//                sum += val;
//                count += 1;
//                if (map.containsKey(val)) {
//                    List<Integer> list = map.get(val);
//                    for (int i : list) {
//                        sum += i;
//                        count += 1;
//                    }
//                }
//            }
//            double avg = (double) sum / count;
//            maxAvg = Math.max(maxAvg, avg);
//        }
//        return maxAvg;
//
//    }
private double max = (double) Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0.0;

        findAvg(root);
        return max;
    }
    //O(N) all nodes called only once and O(N) space worst case
    private Avg findAvg(TreeNode root) {
        if(root == null) return null;
        Avg left = findAvg(root.left);
        Avg right = findAvg(root.right);

        double total = (double) root.val; int nodes = 1;
        if(left != null) {
            total += left.sum;
            nodes += left.nodes;
        }
        if(right != null) {
            total += right.sum;
            nodes += right.nodes;
        }

        max = Math.max( max, total/nodes);
        return new Avg(total, nodes);
    }
    class Avg {
        int nodes;
        double sum;
        public Avg(double sum, int node) {
            this.sum = sum;
            this.nodes = node;
        }
    }


}
