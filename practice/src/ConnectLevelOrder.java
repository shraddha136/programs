import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
        // TODO: Write your code here
        if(root == null){
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            TreeNode temp = null;
            for(int i = 0;i<size;i++){
                TreeNode node = nodeQueue.poll();
                if(temp == null){
                    temp = node;
                }else{
                    temp.next = node;
                    temp = node;
                }
                if(node.left != null){
                    nodeQueue.offer(node.left);
                }
                if(node.right != null){
                    nodeQueue.offer(node.right);
                }
            }
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
