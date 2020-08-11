public class SortedArrayBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = null;
        root = insert(nums, 0, nums.length-1);

        return root;
    }

    private TreeNode insert(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + (end - start) / 2);
        int val = nums[mid];

        TreeNode root = new TreeNode(val);

        root.left = insert(nums, start, mid - 1);
        root.right = insert(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 5, 9};
        System.out.println(new SortedArrayBST().sortedArrayToBST(a));
    }
}
