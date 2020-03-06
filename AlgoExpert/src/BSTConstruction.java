class BSTConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if(value<this.value){
                if(left == null){
                    BST node = new BST(value);
                    left = node;
                }else{
                    left.insert(value);
                }
            }else{
                if(right==null){
                    BST node = new BST(value);
                    right = node;
                }else{
                    right.insert(value);
                }
            }


            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            if(value<this.value){
                if(left==null)
                    return false;
                else
                    return left.contains(value);
            }else if(value>this.value){
                if(right==null)
                    return false;
                else
                    return right.contains(value);
            }
            else
                return true;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            //find the node
            BST root = this;
            BST nodeToDelete = findNode(root,value);
            if(nodeToDelete==null)
                return null;//node not found
            //if leaf node
            if(nodeToDelete.left==null && nodeToDelete.right==null)
                nodeToDelete = null;
            //if has 1 child

            //if has 2 children
            BST node = nodeToDelete;

//            if(node.value == value){//root node
                if(node.left!=null&&node.right!=null){//both children
                    //find smallest node on right tree
                    int smallest = find(node,node.right,false);
                    node.value = smallest;
                }else if(node.left==null && node.right!=null){
                    int smallest = find(node,node.right,false);
                    node.value = smallest;
                }else if(node.left!=null && node.right==null){
                    int largest = find(node,node.left,true);
                    node.value = largest;
                }
//            }
            return this;
        }

        private static BST findNode(BST root,int val){
            if(root==null)
                return null;
            if(root.value == val)
                return root;
            else if(val<root.value)
                return findNode(root.left,val);
            else
                return findNode(root.right,val);

        }
        private static int find(BST parent,BST node,boolean left) {
            if(left){
                while (node.right != null) {
                    parent = node;
                    node = node.right;
                }
                int val = node.value;
                parent.right = null;
                return val;
            }else{
                while (node.left != null) {
                    parent = node;
                    node = node.left;
                }
                int val = node.value;
                parent.left = null;
                return val;
            }

        }
    }

    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(5).insert(15).insert(22).insert(17).insert(16).insert(34).insert(35).insert(27).insert(30).remove(22);
    }
}
