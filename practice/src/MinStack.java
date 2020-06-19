public class MinStack {
    int maxSize;
    int min;
    Stack<Node> stack;

    class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>(maxSize);
    }

    //removes and returns value from stack
    public Integer pop() {
        // Write -- Your -- Code
        if (!stack.isEmpty()) {
            Node node = stack.pop();
            if (!stack.isEmpty()) {
                this.min = stack.top().min;
            } else {
                this.min = -1;
            }
            return node.val;
        }

        return Integer.MIN_VALUE;
    }

    //pushes value into the stack
    public void push(Integer value) {
        // Write -- Your -- Code

        Node newNode = new Node(value, min);
        stack.push(newNode);
        this.min = Math.min(value, this.min);

    }

    //returns minimum value in O(1)
    public int min() {
        // Write -- Your -- Code
        if (!stack.isEmpty()) {
            return this.min;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String args[]) {

        MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);

        System.out.println(stack.min());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.min());

    }

    public class Stack<V> {
        private int maxSize;
        private int top;
        private V[] array;
        private int currentSize;

        /*
        Java does not allow generic type arrays. So we have used an
        array of Object type and type-casted it to the generic type V.
        This type-casting is unsafe and produces a warning.
        Un-comment the line below and execute again to see the warning.
        */
        @SuppressWarnings("unchecked")
        public Stack(int maxSize) {
            this.maxSize = maxSize;
            this.top = -1; //initially when stack is empty
            array = (V[]) new Object[maxSize];//type casting Object[] to V[]
            this.currentSize = 0;
        }

        public int getCurrentSize() {
            return currentSize;
        }

        //returns the maximum size capacity
        public int getMaxSize() {
            return maxSize;
        }

        //returns true if Stack is empty
        public boolean isEmpty() {
            return top == -1;
        }

        //returns true if Stack is full
        public boolean isFull() {
            return top == maxSize - 1;
        }

        //returns the value at top of Stack
        public V top() {
            if (isEmpty())
                return null;
            return array[top];
        }

        //inserts a value to the top of Stack
        public void push(V value) {
            if (isFull()) {
                System.err.println("Stack is Full!");
                return;
            }
            array[++top] = value; //increments the top and adds value to updated top
            currentSize++;
        }

        //removes a value from top of Stack and returns
        public V pop() {
            if (isEmpty())
                return null;
            currentSize--;
            return array[top--]; //returns value and top and decrements the top
        }

    }
}
