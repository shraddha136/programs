import java.util.Arrays;

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = m;
        int d = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[d++];
        }

        while (right < nums1.length) {
            if (nums1[left] > nums1[right])
                swap(left, right, nums1);
            if (nums1[left] <= nums1[right])
                left++;
            if (left == right)
                right++;
        }
    }

    private void swap(int left, int right, int[] nums1) {
        int temp = nums1[left];
        nums1[left] = nums1[right];
        nums1[right] = temp;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 3, 7, 9, 0, 0, 0};
        int nums2[] = {2, 6, 10};
//        new MergeSortedArray().mergeSort(nums1, 4, nums2, 3);
        new MergeSortedArray().mergeSortPointer(nums1, 4, nums2, 3);
    }

    private void mergeSortPointer(int[] nums1, int m, int[] nums2, int n) {
        int[] arrayCopy = new int[m];
        System.arraycopy(nums1, 0, arrayCopy, 0, m);
        int left = 0;
        int right = 0;
        int p = 0;
        while (left < m && right < n) {
            nums1[p++] = arrayCopy[left] < nums2[right] ? arrayCopy[left++] : nums2[right++];
        }
        if (left < m)
            System.arraycopy(arrayCopy, left, nums1, p, m + n - left - right);
        if (right < n)
            System.arraycopy(nums2, right, nums1, p, m + n - left - right);
    }

    private void mergeSort(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
