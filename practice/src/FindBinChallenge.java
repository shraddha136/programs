import java.util.Arrays;

public class FindBinChallenge {
    public static String[] findBin(int number) {
        String[] result = new String[number];
        // Write -- Your -- Code
        Queue<Integer> queue = new Queue<Integer>(number + 1);
        queue.enqueue(1);

        for (int i = 0; i < number; i++) {
            result[i] = String.valueOf(queue.dequeue());
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";

        }
        return result; //For number = 3 , result = {"1","10","11"};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBin(3)));
        System.out.println(Arrays.toString(findBin(4)));
    }
    public static class Queue<V> {
        private int maxSize;
        private V[] array;
        private int front;
        private int back;
        private int currentSize;

        /*
        Java does not allow generic type arrays. So we have used an
        array of Object type and type-casted it to the generic type V.
        This type-casting is unsafe and produces a warning.
        Un-comment the line below and execute again to see the warning.
        */
        @SuppressWarnings("unchecked")
        public Queue(int maxSize) {
            this.maxSize = maxSize;
            array = (V[]) new Object[maxSize];
            front = 0;
            back = -1;
            currentSize = 0;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public int getCurrentSize() {
            return currentSize;
        }

        public V top() {
            return array[front];
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == maxSize;
        }

        public void enqueue(V value) {
            if (isFull())
                return;
            back = (back + 1) % maxSize; //to keep the index in range
            array[back] = value;
            currentSize++;
        }

        public V dequeue() {
            if (isEmpty())
                return null;

            V temp = array[front];
            front = (front + 1) % maxSize; //to keep the index in range
            currentSize--;

            return temp;
        }
    }

}
