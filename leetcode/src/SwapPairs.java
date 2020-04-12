public class SwapPairs {
    public AddNums.ListNode swapPairs(AddNums.ListNode head) {
        if(head == null || head.next == null)
            return head;

        AddNums.ListNode first = head;
        AddNums.ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public static void main(String[] args) {
        AddNums.ListNode node = new AddNums.ListNode(1);
        node.next  = new AddNums.ListNode(2);
        node.next.next  = new AddNums.ListNode(3);
        node.next.next.next  = new AddNums.ListNode(4);
        new SwapPairs().swapPairs(node);
    }
}
