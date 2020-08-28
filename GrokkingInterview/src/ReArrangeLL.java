import java.util.List;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RearrangeLL {

    public static void reorder(ListNode head) {
        // TODO: Write your code here
        //find middle
        //reverse remaining
        //merge alternate
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode reverse = rev(middle);
        ListNode curr = head;
        while(curr != null && reverse != null){
            ListNode temp = curr.next;
            curr.next = reverse;
            curr = temp;

            temp = reverse.next;
            reverse.next = curr;
            reverse = temp;
        }
        if(curr != null){
            curr.next = null;
        }
    }

    private static ListNode rev(ListNode middle) {
        ListNode curr = middle;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeLL.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}