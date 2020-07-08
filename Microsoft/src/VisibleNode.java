import java.util.ArrayList;
import java.util.List;

public class VisibleNode {
    //In a binary tree, if in the path from root to the node A, there is no node with greater value than A’s,
    // this node A is visible. We need to count the number of visible nodes in a binary tree.
    //Input:
    //        5
    //     /     \
    //   3        10
    //  /  \     /
    //20   21   1
    //
    //Output: 4
    //Explanation: There are 4 visible nodes: 5, 20, 21, and 10.

    static class Node{
        Node left, right;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    public List<Integer> getVisibleNodes(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        getVisible(root,root.val,list);
        return list;
    }

    private void getVisible(Node root, int max, List<Integer> list) {
        if(root == null){
            return;
        }
        if(root.val > max){
            list.add(root.val);
        }
        max = Math.max(root.val,max);
        getVisible(root.left,max,list);
        getVisible(root.right,max,list);

    }

    public static void main(String[] args) {
//        Node root = new Node(5);
//        root.left = new Node(3);
//        root.left.left = new Node(20);
//        root.left.right = new Node(21);
//        root.right = new Node(10);
//        root.right.left = new Node(1);
        Node root = new Node(-10);
        root.right = new Node(-15);
        root.right.right = new Node(-1);
        System.out.println(new VisibleNode().getVisibleNodes(root));
    }
}
