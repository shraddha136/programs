import java.util.*;


class RotateLL {
    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode rotate(ListNode head, int rotations) {
        // TODO: Write your code here
        ListNode nodeToEndWith = null;
        int i = 1;

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            i++;
            if(i == rotations)
                nodeToEndWith = curr;
        }
        curr.next = head;

        ListNode newHead = head;
        while(newHead!=nodeToEndWith){
            newHead = newHead.next;
        }
        head = newHead.next;
        for(int k = 0;k<i;k++){
            newHead = newHead.next;
        }
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

        ListNode result = RotateLL.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}