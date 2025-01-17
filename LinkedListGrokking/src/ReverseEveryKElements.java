import java.util.*;


class ReverseEveryKElements {
    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here

        if (k <= 1 || head == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        while (true) {
            ListNode LastNodeOfPrevlist = prev;
            ListNode LastNodeOfSublist = curr;
            ListNode next = null;
            for (int i = 0; curr != null && i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if (LastNodeOfPrevlist != null)
                LastNodeOfPrevlist.next = prev;
            else
                head = prev;

            LastNodeOfSublist.next = curr;
            for (int i = 0; curr != null && i < k; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (curr == null)
                break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}