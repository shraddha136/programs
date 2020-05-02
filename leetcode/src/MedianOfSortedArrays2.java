public class MedianOfSortedArrays2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;


        int[] x = nums1.length < nums2.length ? nums1 : nums2;
        int[] y = nums1.length < nums2.length ? nums2 : nums1;
        int start = 0;
        int end = x.length;

        while (start <= end) {
            int midX = (start + end) / 2;
            int midY = ((x.length + y.length + 1) / 2) - midX;

            int minX = midX == len1 ? Integer.MAX_VALUE : x[midX];
            int minY = midY == len2 ? Integer.MAX_VALUE:y[midY];
            int maxX = midX == 0 ? Integer.MIN_VALUE: x[midX-1];
            int maxY = midY == 0 ? Integer.MIN_VALUE: y[midY -1];
            if (maxX<=minY && maxY<=minX)
                return getMedian(minX, minY, maxX, maxY,  x, y);
            else if (maxX > minY)
                end = midX - 1;
            else
                start = midX + 1;
        }
        return 0.0;
    }

    private double getMedian(int minX, int minY, int maxX, int maxY, int[] x, int[] y) {
        boolean even = (x.length + y.length) % 2 == 0;
        if (even) {
            return (Math.min(minX, minY) + Math.max(maxX, maxY)) / 2.0;
        } else
            return Math.max(maxX, maxY);
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 3, 8, 9, 15};
//        int[] nums2 = {7, 11, 18, 19, 21, 25};
        int[] nums1 = {1,3,5};
        int[] nums2 = {2,4,6};
//        int[] nums1 = {23,26,31,35};
//        int[] nums2 = {3,5,7,9,11,16};
        System.out.println(new MedianOfSortedArrays2().findMedianSortedArrays(nums1, nums2));
    }
}
