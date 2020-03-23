import java.util.PriorityQueue;

class MergeKLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode result = new ListNode(-1);
        ListNode res = result;

        for (ListNode list : lists) {
            minHeap.offer(list);
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            res.next = new ListNode(node.val);
            if (node.next != null)
                minHeap.offer(node.next);
            res = res.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(4);
        list.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        ListNode[] array = {list, list2, list3};
        mergeKLists(array);

    }
}