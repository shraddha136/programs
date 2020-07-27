import java.util.HashSet;
import java.util.Set;

public class LeafParent {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    public Set<Integer> getParents(Node root){
        if(root == null){
            return null;
        }
        Set<Integer> result = new HashSet<>();
        parent(root,null,result);
        return result;
    }

    private void parent(Node root, Node parent, Set<Integer> result) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(parent.val);
        }
        parent(root.left,root,result);
        parent(root.right,root,result);
    }

    public static void main(String[] args) {
        Node root = new Node(500);
        root.left = new Node(300);
        root.right = new Node(600);
        root.left.left = new Node(100);
        root.left.right = new Node(350);
        root.left.right.left = new Node(320);
        root.left.right.right = new Node(360);
        System.out.println(new LeafParent().getParents(root));
    }
}
