import java.util.*;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        TreeNode root = new TreeNode(nums[nums.length-1]);
        result.add(0,0);

        for(int i = nums.length-2;i>=0;i--){
            int count = insert(nums[i],root,0).count;
            result.add(0,count);
        }
        return result;
    }

    private TreeNode insert(int num, TreeNode root, int count) {
        if(root == null){
            root = new TreeNode(num);
            root.count = count;
        }else if(num < root.val){
            count += root.count;
            root.left = insert(num,root.left,count);
        }else if(num == root.val){
            root.count++;
        }else{
            count += root.count;
            root.right = insert(num,root.right,count);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = {3,2,2,6,1};
        System.out.println(new CountSmaller().countSmaller(a));
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int count = 1;
    public TreeNode(int val) {
        this.val = val;
    }
}
