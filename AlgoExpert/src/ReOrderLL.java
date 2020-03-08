/**
 * Definition for singly-linked list.
 */

class ReOrderLL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void reorderList(ListNode head) {
        //find the middle node
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse middlenode
        ListNode middle = reverse(slow);

        //traverse from head and middle and connect
        ListNode newHead = head;
        while (middle.next != null) {
            ListNode newHeadNext = newHead.next;
            ListNode middleNext = middle.next;
            newHead.next = middle;
            middle.next = newHeadNext;
            newHead = newHeadNext;
            middle = middleNext;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reorderList(node);
    }
}