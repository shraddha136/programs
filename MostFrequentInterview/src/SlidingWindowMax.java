import java.util.*;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] arr, int windowSize) {
        List<Integer> result = new ArrayList<>(); // ArrayDeque for storing values
        ArrayDeque<Integer> queue = new ArrayDeque<>(); // creating a linked list

        for (int i = 0; i < windowSize; i++) {
            while (!queue.isEmpty() && queue.peekLast() < arr[i]) {
                queue.pollLast();
            }
            queue.offerLast(arr[i]);
        }

        for (int i = windowSize; i < arr.length; i++) {
            result.add(queue.peekFirst());

            while (!queue.isEmpty() && queue.size() >= windowSize) {
                queue.remove(arr[i - windowSize]);
            }
            while (!queue.isEmpty() && queue.peekLast() < arr[i]) {
                queue.pollLast();
            }
            queue.offerLast(arr[i]);
        }
        result.add(queue.getFirst());
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new SlidingWindowMax().maxSlidingWindow(a, 3)));
    }
}
