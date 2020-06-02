import java.util.*;

public class BinaryTree {
    Node root;
    public BinaryTree(int val){
        this.root = new Node(val);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
//        tree.root.right.right.right = new Node(8);

//        dfsTraversalIter(tree.root);
//        System.out.println("\n"+"****************");
//        dfsTraversalRec(tree.root);
//        System.out.println("\n"+"********BFS********");
//        bfsTraversalIter(tree.root);
//        System.out.println("\n"+"****************");
//        bfsTraversalRec(tree.root);
//        System.out.println("\n"+"****************");
//        PreOrder(tree.root);
//        System.out.println("\n"+"****************");
//        InOrder(tree.root);
//        System.out.println("\n"+"****************");
//        PostOrder(tree.root);
//        System.out.println("\n"+"****************");
//        RevLevelOrder(tree.root);
//        System.out.println(getHeight(tree.root));

        System.out.println(getSuccessor(tree.root,tree.root.left));
    }

    private static Node getSuccessor(Node root, Node p) {
        if(root == null)
            return root;
        Node node = getInOrder(root,p,false);
        return getInOrder(node,new Node(-1),true);
    }
    static Node node = null;
    private static Node getInOrder(Node root, Node toFind, boolean done){
        if(root == null  || done || root == toFind)
            return root;
        node = getInOrder(root,toFind,done);
        if(root == toFind){
            node =  root;
        }                                                                                              [''''''''''''''''''



    ]












        node = getInOrder(root,toFind,done);
        return node;
    }


    private static int getHeight(Node root) {
        if(root == null)
            return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left,right);
    }

    private static void RevLevelOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Node node = queue.poll();
                stack.push(node);
                if(node.right!=null)
                    queue.offer(node.right);
                if(node.left!=null)
                    queue.offer(node.left);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Node i:stack)
            list.add(0, i.val);
        System.out.println(list);
    }


    private static void PreOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.val);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    private static void InOrder(Node root) {
        if(root == null)
            return;
        InOrder(root.left);
        System.out.print(root.val);
        InOrder(root.right);
    }

    private static void PostOrder(Node root) {
        if(root == null)
            return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.val);
    }

    private static void bfsTraversalRec(Node root) {
    }

    private static void bfsTraversalIter(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
    }

    private static void dfsTraversalRec(Node root) {
        if(root == null)
            return;
        System.out.print(root.val+" ");
        dfsTraversalRec(root.left);
        dfsTraversalRec(root.right);
    }

    private static void dfsTraversalIter(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);

        }
    }
    
    


}
