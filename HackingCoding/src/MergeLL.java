class MergeSortList {
//    public static LinkedListNode mergeSorted(LinkedListNode head1, LinkedListNode head2) {
//        //TODO: Write - Your - Code
//        LinkedListNode res = new LinkedListNode(0);
//        LinkedListNode r = res;
//        System.out.println(res.data);
//        System.out.println(r.data);
//
//        while (head1 != null && head2 != null) {
//            if (head1.data < head2.data) {
//                r.next = new LinkedListNode(head1.data);
//                System.out.println(head1.data);
//                r = r.next;
//                head1 = head1.next;
//            } else {
//                System.out.println(head2.data);
//                r.next = new LinkedListNode(head2.data);
//                r = r.next;
//                head2 = head2.next;
//            }
//        }
//
//        if (head1 != null) {
//            r.next = head1;
//        }
//        if (head2 != null) {
//            r.next = head2;
//        }
//
//        return res.next;
//    }

    private static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        public LinkedListNode(int i) {
            this.data = i;
        }
    }

//    public static LinkedListNode reverseEvenNodes(LinkedListNode head) {
//        //TODO: Write - Your - Code
//
//        //split into 2 lists
//        LinkedListNode curr = head;
//        LinkedListNode even = null;
//        while(curr!= null && curr.next != null){
//            LinkedListNode even1 = curr.next;
//            curr.next = even1.next;
//
//            even1.next = even;
//            even = even1;
//            curr = curr.next;
//        }
//        //merge lists
//        return merge(head,even);
//
//    }

//    private static LinkedListNode merge(LinkedListNode head, LinkedListNode even) {
//        LinkedListNode curr = head;
//        LinkedListNode result = new LinkedListNode(0);
//        LinkedListNode res = result;
//        while (curr!=null && even!=null){
//            res.next = new LinkedListNode(curr.data);
//            res.next.next = new LinkedListNode(even.data);
//            res = res.next.next;
//            curr = curr.next;
//            even = even.next;
//        }
//        if(curr!=null)
//            res.next = new LinkedListNode(curr.data);
//
//        return result.next;
//    }

//    public static LinkedListNode rotateList(LinkedListNode head, int n) {
//        //TODO: Write - Your - Code
//        int len = 1;
//        LinkedListNode curr = head;
//        while(curr.next != null){
//            len++;
//            curr = curr.next;
//        }
//        System.out.println(len);
//
//        if(n<0)
//            n += len;
//        n = n % len;
//        System.out.println(n);
//
//        curr.next = head;
//        curr = head;
//        for(int i = 0;i<len - n;i++){
//            curr = curr.next;
//        }
//        LinkedListNode oldHead = curr;
//        curr = oldHead;
//        for(int i = 0;i<len-1;i++){
//            curr = curr.next;
//        }
//        curr.next = null;
//        return oldHead;
//    }

//    static LinkedListNode reverseKNodes(LinkedListNode head, int k) {
//        //TODO: Write - Your - Code
//        LinkedListNode reversed;
//        LinkedListNode currHead = null;
//        LinkedListNode currTail;
//        LinkedListNode prevTail;
//        LinkedListNode curr = head;
//        LinkedListNode prev = null;
//        LinkedListNode next = null;
//        currTail = curr;
//
//        for(int i = 0;i<k && curr!=null;i++){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        head.next = currHead;
//        currHead = head;
//        head = next;
//
//        return head;
//    }
    static LinkedListNode addIntegers(LinkedListNode integer1, LinkedListNode integer2) {
        //TODO: Write - Your - Code
        LinkedListNode res = new LinkedListNode(0);
        LinkedListNode result = res;
        int sum = 0;
        int carry = 0;
        while(integer1!=null && integer2!=null){
            sum = carry + integer1.data + integer2.data;
            carry = 0;
            if(sum>9){
                carry = 1;
            }
            sum = sum %10;
            result.next = new LinkedListNode(sum);
            result = result.next;
            integer1 = integer1.next;
            integer2 = integer2.next;
        }
        if(integer1!=null)
            result.next = new LinkedListNode(integer1.data+carry);
        if(integer1!=null)
            result.next = new LinkedListNode(integer2.data+carry);
        return res.next;
    }

    public static void main(String[] args) {
        LinkedListNode l = new LinkedListNode(1);
        l.next = new LinkedListNode(2);
        l.next.next = new LinkedListNode(3);
        l.next.next.next = new LinkedListNode(4);
        l.next.next.next.next = new LinkedListNode(5);
        l.next.next.next.next = new LinkedListNode(6);
        l.next.next.next.next = new LinkedListNode(7);
//        rotateList(l,2);

//        LinkedListNode l2 = new LinkedListNode(7);
//        l2.next = new LinkedListNode(9);
//        l2.next.next = new LinkedListNode(10);
//        l2.next.next.next = new LinkedListNode(16);

//        mergeSorted(l, l2);
    }
}