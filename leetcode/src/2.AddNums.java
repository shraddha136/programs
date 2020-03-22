class AddNums {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode list = new ListNode(9);
        list.next = new ListNode(9);
//        list.next.next = new ListNode(3);
        print(list);
        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(6);
//        list2.next.next = new ListNode(4);
        print(list2);
        ListNode l3 = add(list, list2);
        print(l3);

    }

    private static ListNode add(ListNode n1, ListNode n2) {
        ListNode sums = new ListNode(0);
        ListNode s = sums;
        int carry = 0;
        while(n1!=null || n2 != null){
            int x = n1!=null?n1.val:0;
            int y = n2!=null?n2.val:0;
            int sum = carry + x + y;
            carry = sum/10;
            s.next = new ListNode(sum%10);
            s = s.next;
            if(n1!=null) n1 = n1.next;
            if(n2!=null) n2 = n2.next;
        }
        if(carry>0)
            s.next = new ListNode(carry);
        return sums.next;
    }


//    private static ListNode add(ListNode n1, ListNode n2) {
//        if (n1 == null)
//            return n2;
//        else if (n2 == null)
//            return n1;
//        else {
//            int carry = 0;
//            ListNode sums = new ListNode(0);
//            ListNode s = sums;
//            while (n1 != null && n2 != null) {
//                int sum = 0;
//                if (carry == 1)
//                    sum = 1;
//                sum = sum + n1.val + n2.val;
//                s.next = new ListNode(sum%10);
//                carry = sum > 9 ? 1 : 0;
//                n1 = n1.next;
//                n2 = n2.next;
//                s = s.next;
//            }
//            while (n1 != null) {
//                int sum = 0;
//                if (carry == 1)
//                    sum = 1;
//                sum = sum + n1.val;
//                s.next = new ListNode(sum);
//                carry = sum > 9 ? 1 : 0;
//                n1 = n1.next;
//                s = s.next;
//            }
//            while (n2 != null) {
//                int sum = 0;
//                if (carry == 1)
//                    sum = 1;
//                sum = sum + n2.val;
//                s.next = new ListNode(sum);
//                carry = sum > 9 ? 1 : 0;
//                n2 = n2.next;
//                s = s.next;
//            }
//            if(carry == 1)
//                s.next = new ListNode(carry);
//            return sums.next;
//        }
//    }

    private static void print(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
        System.out.println();
    }
}
