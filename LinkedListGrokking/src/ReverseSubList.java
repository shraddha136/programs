import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
      if(p==q)
          return head;
      ListNode curr = head;
      ListNode prev = null;
      for(int i = 1;curr!=null && i<p;i++){
          prev = curr;
          curr = curr.next;
      }
      ListNode nodeBeforeP = prev;
      ListNode lastNodeP = curr;

      ListNode prevNode = null;
      for(int i = p;i<=q;i++){
          ListNode next = curr.next;
          curr.next = prevNode;
          prevNode = curr;
          curr = next;
      }

      if(nodeBeforeP!=null)
          nodeBeforeP.next = prevNode;
      else
          nodeBeforeP = head;
      lastNodeP.next = curr;
      return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}