import java.util.List;

public class ListPalindrome {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode reverse = reverse(middle);
        ListNode curr = head;
        while(reverse!=null && curr!=null){
            if(reverse.val !=curr.val)
                return false;
            reverse = reverse.next;
            curr = curr.next;
        }
        middle.next = reverse(middle);
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next  = new ListNode(2);
        node.next.next  = new ListNode(2);
        node.next.next.next  = new ListNode(1);
        new ListPalindrome().isPalindrome(node);
    }
}
