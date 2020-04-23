/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class CircularSortedLL {
    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node newNode = new Node(insertVal);
            head = newNode;
            head.next = head;
        }

        if (head.next == head) {
            Node newNode = new Node(insertVal, head);
        }

        Node prev = null;
        Node curr = head;
        Node tail = null;
        int max = Integer.MIN_VALUE;

        while (true) {
            if (prev == null) {
                prev = curr;
                curr = curr.next;
            }

            if (max <= curr.val) {
                max = curr.val;
                tail = curr;
            }

            if (prev.val <= insertVal && insertVal <= curr.val) {
                Node newNode = new Node(insertVal);
                newNode.next = prev.next;
                prev.next = newNode;
                break;
            }

            if (prev.next == head) {
                Node newNode = new Node(insertVal);
                newNode.next = tail.next;
                tail.next = newNode;
                break;
            }

            prev = curr;
            curr = curr.next;
        }


        return head;
    }

    private static class Node {
        public Node next;
        public int val;

        public Node(int val, Node next) {
            this.next = next;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(4);
        node.next.next = new Node(1);
        node.next.next.next = node;
        new CircularSortedLL().insert(node, 5);
    }
}
