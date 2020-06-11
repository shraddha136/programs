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
        ListNode curr = head;
        int count = 0;
        for(int i = 0;curr!=null && count !=k;i++){
            curr=curr.next;
            count++;
        }
        if(count == k){
            curr = reverse(curr,k);
            for(int i = 0;curr!=null && i!=k;i++){
                curr = curr.next;
            }
            while(count-->0){
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }


            head = curr;

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