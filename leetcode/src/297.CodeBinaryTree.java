import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CodeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        int height = getHeight(root);
//        Integer[] allNodes = new Integer[(int) (Math.pow(2, height) - 1)];
//        ser(0, allNodes, root);
//        StringBuilder sb = new StringBuilder("[");
//        for (int i = 0; i < allNodes.length; i++) {
//            sb.append(allNodes[i]);
//            if (i != allNodes.length - 1)
//                sb.append(",");
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//    private void ser(int i, Integer[] allNodes, TreeNode root) {
//        if (root == null)
//            if (i < allNodes.length)
//                allNodes[i] = null;
//
//        allNodes[i] = root.val;
//        if (root.left != null)
//            ser(2 * i + 1, allNodes, root.left);
//        if (root.right != null)
//            ser(2 * i + 2, allNodes, root.right);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if(data.length() == 0)
//            return null;
//        String[] nodes = data.substring(1, data.length() - 1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//
//        deser(0, nodes, root);
//        return root;
//    }
//
//    private void deser(int i, String[] nodes, TreeNode root) {
//        if (i >= nodes.length/2 || root == null)
//            return;
//        String left = nodes[2 * i + 1];
//        if(left == null)
//            return;
//        root.left = left.equals("null") ? null : new TreeNode(Integer.parseInt(left));
//        String right = nodes[2 * i + 2];
//        if(right == null)
//            return;
//        root.right = right.equals("null") ? null : new TreeNode(Integer.parseInt(right));
//        deser(2 * i + 1, nodes, root.left);
//        deser(2 * i + 2, nodes, root.right);
//    }
//
//
//    private int getHeight(TreeNode root) {
//        if (root == null)
//            return 0;
//        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
//    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String tree = "";
        return reSerialize(tree, root);
    }

    private String reSerialize(String tree, TreeNode root) {
        if (root == null) {
            tree += "null,";
            return tree;
        }
        tree += root.val + ",";
        tree = reSerialize(tree, root.left);
        tree = reSerialize(tree, root.right);
        return tree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(val));
        TreeNode node =  reDeserialize(list);
        return node;
    }

    private TreeNode reDeserialize(List<String> list) {
        if (list.get(0).contentEquals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        node.left = reDeserialize(list);
        node.right = reDeserialize(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
//        root.left.left = new TreeNode(4);
//        root.right.left = new TreeNode(7);
//        root.left.right = new TreeNode(4);
//        String data = new CodeBinaryTree().serialize(root);
//        System.out.println(data);
//        TreeNode newTree = new CodeBinaryTree().deserialize(data);
        new CodeBinaryTree().deserialize(new CodeBinaryTree().serialize(root));
    }
}
