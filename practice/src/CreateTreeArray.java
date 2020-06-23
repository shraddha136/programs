public class CreateTreeArray {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node createTreeFromArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        return createTreeFromArray(array, 0, array.length - 1);
    }

    private int findMax(int[] array, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = start; i <= end; i++) {
            if (max < array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private Node createTreeFromArray(int[] array, int start, int end) {
        if (start < 0 || end >= array.length) {
            return null;
        }
        int maxIndex = findMax(array, start, end);
        Node root = null;
        if (maxIndex > -1 && maxIndex < array.length) {
            root = new Node(array[maxIndex]);
            root.left = createTreeFromArray(array, start, maxIndex - 1);
            root.right = createTreeFromArray(array, maxIndex + 1, end);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 6, 0, 5};
        Node node = new CreateTreeArray().createTreeFromArray(array);
        System.out.println(node);
    }
}
