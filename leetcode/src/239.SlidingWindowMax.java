import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class MaxSlidingWindow {

    public static int[] findMaxSlidingWindow(int[] arr, int windowSize) {

        ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
        Deque<Integer> list = new LinkedList<Integer>(); // creating a linked list

        for (int i = 0; i < windowSize; i++) {

            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
        }


        for (int i = windowSize; i < arr.length; ++i) {
            result.add(arr[list.peek()]);

            //remove out of window indices
            while (!list.isEmpty() && list.peekFirst() < i - windowSize +1)
                list.removeFirst();
            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);

        }
        result.add(arr[list.peek()]);

        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {

        int[] array = {-4, 2, -5, 1, -1, 6};
        System.out.println("Array = " + Arrays.toString(array));
        System.out.println("Max = " + Arrays.toString(findMaxSlidingWindow(array, 3)));


//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println("Array = " + Arrays.toString(array));
//        System.out.println("Max = " + findMaxSlidingWindow(array, 3));
//
//        int[] array2 = {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
//        System.out.println("Array = " + Arrays.toString(array2));
//        System.out.println("Max = " + findMaxSlidingWindow(array2, 3));
    }
}