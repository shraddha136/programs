public class TwoNodeDistance {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            left = right = null;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.left.left= new Node(1);
        root.left.right= new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(10);
        root.right.right.right = new Node(11);
        System.out.println(distance(root, 2,11));
    }


    private static int distance(Node root, int a, int b) {
        if(root == null){
            return 0;
        }
        if(a < root.val && b < root.val){
            return distance(root.left,a,b);
        }else if(a > root.val && b > root.val){
            return distance(root.right,a,b);
        }else if(root.val >= a && root.val <= b){
            return distance(root,a)+distance(root,b);
        }
        return 0;
    }

    private static int distance(Node root, int a) {
        if(root.val == a){
            return 0;
        }else if(root.val > a){
            return 1 + distance(root.left,a);
        }
            return 1 + distance(root.right,a);

    }

}
