import java.util.ArrayList;
import java.util.List;

class DeleteKth {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        // Writ e your code here.
        if (k == 0 || head == null)
            return;
        int count = 1;
        LinkedList slow = head;
        LinkedList fast = head;
        while(count!=k){
            k++;
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        assert slow.next != null;
        slow = slow.next.next;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


}
