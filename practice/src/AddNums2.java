import java.util.Stack;

public class AddNums2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int p = stack1.isEmpty() ? 0 : stack1.pop();
            int q = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = p + q + carry;
            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            newNode.next = res;
            res = newNode;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = res;
            res = newNode;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode list = new ListNode(7);
        list.next = new ListNode(2);
        list.next.next = new ListNode(4);
        list.next.next.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        ListNode l3 = new AddNums2().addTwoNumbers(list, list2);
        System.out.println(l3);
    }
}
