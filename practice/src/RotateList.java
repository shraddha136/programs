import java.util.*;



class RotateList {
    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    public static ListNode rotate(ListNode head, int rotations) {
        // TODO: Write your code here
        int len = 1;
        ListNode curr = head;
        ListNode copyHead = head;
        while(curr.next!=null){
            len++;
            curr = curr.next;
        }
        curr.next = head;

        rotations = rotations % len;
        int skip = len - rotations;
        ListNode newHead = head;
        for(int i = 0;i<skip-1;++i){
            newHead = newHead.next;
        }
        head = newHead.next;
        newHead.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}