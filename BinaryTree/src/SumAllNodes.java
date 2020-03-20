import java.util.*;

public class SumAllNodes {
    static class Node{
        int val;
        Node left;
        Node right;
        
        public Node(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    private static int sum(Node root){
        int sum = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            sum += node.val;
            if(node.left!=null)
                stack.push(node.left);
            if(node.right!=null)
                stack.push(node.right);
        }
        return sum;
    }

    private static int levelDiff(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            int sum = 0;
            for(int i = 0;i<n;i++){
                Node node = queue.poll();
                sum += node.val;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            list.add(sum);
        }
        int even = 0;
        int odd = 0;
        for(int i = 0;i<list.size();i++){
            if(i%2==0)
                even += list.get(i);
            else
                odd += list.get(i);
        }
        return even-odd;
    }


    private static int levelDiff2(Node root){
        if(root == null)
            return 0;
        return root.val - levelDiff2(root.left)-levelDiff2(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.left.right.left = new Node(10);
        root.right.right.left.left = new Node(11);
        System.out.println("Tree Sum: " + levelDiff2(root));
    }
}
