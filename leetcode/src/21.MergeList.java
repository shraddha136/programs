import java.util.List;

class MergeList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if (l2==null)
            return l1;
        else if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    public static ListNode mergeIter(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode res = result;
        while(l1 != null && l2 !=null){
            if(l1.val<=l2.val){
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }
        if(l1 !=null)
            res.next = l1;
        if(l2 != null)
            res.next = l2;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(4);
        print(list);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        print(list2);
        ListNode l4 = mergeIter(list,list2);
        print(l4);
        ListNode l3 = mergeTwoLists(list,list2);
        print(l3);

    }
    private static void print(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
        System.out.println();
    }
}
