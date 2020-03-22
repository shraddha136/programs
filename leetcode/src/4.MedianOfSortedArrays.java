import java.util.PriorityQueue;

class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        minHeap = new PriorityQueue<>((a, b) -> Double.compare(a, b));
        for (int n : nums1)
            buildHeap(n);
        for (int n : nums2)
            buildHeap(n);

        return getMedian();
    }

    private PriorityQueue<Double> maxHeap;
    private PriorityQueue<Double> minHeap;

    public void buildHeap(double n) {
        if (maxHeap.isEmpty() || maxHeap.peek() > n) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
        balanceHeap();

    }

    private void balanceHeap() {
        if (minHeap.size() == maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

}
