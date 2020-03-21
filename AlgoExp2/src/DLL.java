// Feel free to add new properties and methods to the class.
class DLL {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            System.out.println("setting head");
            // Write your code here.
            if (head == null) {
                head = node;
                tail = node;
            } else {
                Node currHead = head;
                node.next = currHead;
                currHead.prev = node;
                head = node;
            }
        }

        public void setTail(Node node) {
            System.out.println("setting tail");

            // Write your code here.
            if (head == null) {
                head = tail = node;
            } else if (head == tail) {
                head.next = node;
                node.prev = head;
                tail = node;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                tail = curr;
            }
        }


        public void insertBefore(Node node, Node nodeToInsert) {
            System.out.println("insert before"+node.value);

            // Write your code here.
            //before head
            if (node == head) {
                node.prev = nodeToInsert;
                nodeToInsert.next = node;
                head = nodeToInsert;
            }
            //before tail
            else if (node == tail) {
                Node tailprev = tail.prev;
                nodeToInsert.next = node;
                nodeToInsert.prev = tailprev;
                tailprev.next = nodeToInsert;
                node.prev = nodeToInsert;
            } else {            //before node

                Node curr = head;
                while (curr != null && curr.value != node.value) {
                    curr = curr.next;
                }

                Node nodePrev = curr.prev;
                nodeToInsert.next = curr;
                nodeToInsert.prev = nodePrev;
                curr.prev = nodeToInsert;
                nodePrev.next = nodeToInsert;
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            System.out.println("insert after"+node.value);

            // Write your code here.
            //after head

            if (head == node) {
                Node headNext = head.next;
                head.next = nodeToInsert;
                nodeToInsert.prev = head;
                nodeToInsert.next = headNext;
                headNext.prev = nodeToInsert;
            }
            //after tail
            else if (tail == node) {
                Node tailNext = tail.next;
                tail.next = nodeToInsert;
                nodeToInsert.prev = tail;
                nodeToInsert.next = tailNext;
                tail = nodeToInsert;
            }
            //after node
            else {
                Node curr = head;
                while (curr != null && curr.value != node.value) {
                    curr = curr.next;
                }
                Node nodeNext = curr.next;
                curr.next = nodeToInsert;
                nodeToInsert.prev = curr;
                nodeToInsert.next = nodeNext;
                nodeNext.prev = nodeToInsert;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            System.out.println("insert pos");

            // Write your code here.
            if (position == 0){
                insertBefore(head, nodeToInsert);
                return;
            }
            int i = 1;
            Node curr = head;
            while (curr != null && i < position ) {
                curr = curr.next;
                i++;
            }
            if (curr == null)
                insertAfter(tail, nodeToInsert);
            else
                insertBefore(curr, nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            System.out.println("remove"+value);

            // Write your code here.
            if (head == null)
                return;
            Node curr = head;
            while (curr != null) {
                if (curr.value == value){
                    remove(curr);
                    return;
                }
                curr = curr.next;
            }
        }

        public void remove(Node node) {
            System.out.println("remove"+node.value);

            // Write your code here.
            //node is head
            if(node.value == head.value){
                head = head.next;
                head.prev = null;
            }
            //node is tail
            else if(node.value == tail.value){
                tail = tail.prev;
                tail.next = null;
            }
            //regular node
            else{
                Node curr = head;
                while (curr != null) {
                    if (curr.value == node.value)
                       break;
                    curr = curr.next;
                }
                Node nodePrev = curr.prev;
                Node nodeNext = curr.next;
                nodePrev.next = nodeNext;
                nodeNext.prev = nodePrev;
            }
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            if (head == null)
                return false;
            Node curr = head;
            while (curr != null) {
                if (curr.value == value)
                    return true;
                curr = curr.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node head = new Node(1);
        Node tail = new Node(2);
        dll.setHead(head);
        dll.setTail(tail);
        printList(dll);
        dll.insertBefore(head, new Node(3));
        printList(dll);
        dll.insertBefore(tail, new Node(4));
        printList(dll);
        dll.insertBefore(new Node(4), new Node(5));
        printList(dll);
        dll.insertAfter(dll.head, new Node(6));
        printList(dll);
        dll.insertAfter(dll.tail, new Node(7));
        printList(dll);
        dll.insertAfter(new Node(5), new Node(8));
        printList(dll);
        dll.insertAtPosition(0, new Node(9));
        printList(dll);
        dll.insertAtPosition(4, new Node(10));
        printList(dll);
        dll.insertAtPosition(12, new Node(11));
        printList(dll);
        System.out.println(dll.containsNodeWithValue(10));
        System.out.println(dll.containsNodeWithValue(7));
        System.out.println(dll.containsNodeWithValue(-1));
        dll.remove(dll.head);
        printList(dll);
        dll.remove(dll.tail);
        printList(dll);
        dll.remove(new Node(10));
        printList(dll);
        dll.removeNodesWithValue(1);
        printList(dll);

    }

    private static void printList(DoublyLinkedList head) {
        Node curr = head.head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
        System.out.println();
    }
}
