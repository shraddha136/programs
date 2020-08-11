import com.sun.source.tree.BinaryTree;

import java.util.*;

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
class Vertical {
    class Node{
        TreeNode node;
        int vIdx;
        int hIdx;
        Node(TreeNode node, int hIdx,int vIdx){
            this.node = node;
            this.hIdx = hIdx;
            this.vIdx = vIdx;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<Node>> map = new HashMap<>();
        int min=0;
        int max = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root,0,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Node currNode = queue.poll();
                int hIdx = currNode.hIdx;
                int vIdx = currNode.vIdx;

                List<Node> list = new ArrayList<>();
                if(map.containsKey(hIdx)){
                    list = map.get(hIdx);
                }
                list.add(currNode);
                map.put(hIdx,list);
                if(currNode.node.left != null){
                    queue.offer(new Node(currNode.node.left,hIdx-1,vIdx-1));
                    min = Math.min(min, hIdx-1);
                }

                if(currNode.node.right != null){
                    queue.offer(new Node(currNode.node.right, hIdx+1,vIdx-1));
                    max = Math.max(max, hIdx+1);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = min;i<=max;i++){
            List<Node> list = map.get(i);
            Collections.sort(list, new Comparator<Node>(){
                @Override
                public int compare(Node a, Node b){
                    return a.vIdx-b.vIdx;
                }
            });
            List<Integer> temp = new ArrayList<>();
            for(Node node:list){
                temp.add(node.node.val);
            }
            result.add(temp);

        }
        return result;
    }

    public static void main(String[] args) {

    }
}