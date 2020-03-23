//public class DoublyLinkedList {
//    static class Node {
//        Node next;
//        Node prev;
//        int value;
//
//        public Node(int val) {
//            this.value = val;
//            next = prev = null;
//        }
//    }
//
//    public Node head;
//    public Node tail;
//
//    public void setHead(Node node) {
//        if (head == null)
//            head = tail = node;
//        else
//            insertBefore(head, node);
//    }
//
//    public void setTail(Node node) {
//        if (tail == null)
//            setHead(node);
//        else
//            insertAfter(tail, node);
//    }
//
//    public void insertBefore(Node node, Node nodeToInsert) {
//        if (nodeToInsert == head && nodeToInsert == tail)
//            return;
//        remove(nodeToInsert);
//        nodeToInsert.prev = node.prev;
//        nodeToInsert.next = node;
//        if (node.prev == null)
//            head = nodeToInsert;
//        else
//            node.prev.next = nodeToInsert;
//        node.prev = nodeToInsert;
//    }
//
//    public void insertAfter(Node node, Node nodeToInsert) {
//        if (nodeToInsert == head && nodeToInsert == tail) {
//            return;
//        }
//        remove(nodeToInsert);
//        nodeToInsert.prev = node;
//        nodeToInsert.next = node.next;
//        if (node.next == null)
//            tail = nodeToInsert;
//        else {
//            node.next.prev = nodeToInsert;
//        }
//        node.next = nodeToInsert;
//    }
//
//    public void insertAtPosition(int pos, Node nodeToInsert) {
//        if (pos == 1) {
//            setHead(nodeToInsert);
//            return;
//        } else {
//            int i = 1;
//            Node curr = head;
//            while (curr != null && i != pos) {
//                curr = curr.next;
//                i++;
//            }
//            if (curr == null)
//                setTail(nodeToInsert);
//            else
//                insertBefore(nodeToInsert, curr);
//        }
//    }
//
//    public boolean containsNodeWithValue(int value) {
//        Node curr = head;
//        while (curr != null) {
//            if (curr.value == value)
//                return true;
//            curr = curr.next;
//        }
//        return false;
//    }
//
//    public void remove(Node nodeToRemove) {
//
//        if (nodeToRemove == head) {
//            head = head.next;
//        }
//        if (nodeToRemove == tail) {
//            tail = tail.prev;
//        }
//        //update node's prev's and next's pointers
//        removeNodeBindings(nodeToRemove);
//    }
//
//    private void removeNodeBindings(Node node) {
//        if (node.prev != null)
//            node.prev.next = node.next;
//        if (node.next != null)
//            node.next.prev = node.prev;
//        node.prev = null;
//        node.next = null;
//    }
//
//    public void removeNodesWithValue(int value) {
//        Node curr = head;
//        while (curr != null) {
//            Node next = curr.next;
//            if (curr.value == value) {
//                remove(curr);
//            }
//            curr = next;
//        }
//    }
//
//    public static void main(String[] args) {
//        DoublyLinkedList list = new DoublyLinkedList();
//        Node head = new Node(1);
//        Node tail = new Node(1);
//        Node node3 = new Node(1);
//        Node node4 = new Node(1);
//        Node node5 = new Node(1);
//        Node node6 = new Node(1);
//        Node node7 = new Node(1);
//        list.setHead(head);
//        list.setTail(tail);
//        list.remove(head);
//        list.remove(tail);
//        list.setHead(head);
//        list.insertAfter(tail, head);
//        list.remove(head);
//        list.remove(tail);
//        list.setHead(head);
//        list.insertBefore(tail, head);
//        list.remove(head);
//        list.remove(tail);
//        list.insertAtPosition(1, head);
//        list.insertAtPosition(2, tail);
//        list.remove(head);
//        list.remove(tail);
//        list.insertAtPosition(2, head);
//        list.insertAtPosition(1, tail);
//    }
//}
