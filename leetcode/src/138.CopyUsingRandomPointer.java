import java.util.HashMap;
import java.util.Map;

class CopyUsingRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

//    public Node copyRandomList(Node head) {
//        Map<Node,Node> map = new HashMap<>();
//
//        Node curr = head;
//        while(curr!=null){
//            map.put(curr,new Node(curr.val));
//            curr = curr.next;
//        }
//
//        curr = head;
//        while(curr!=null){
//            Node node = map.get(curr);
//            node.next = map.get(curr).next;
//            node.random = map.get(curr.random);
//
//            curr = curr.next;
//        }
//        return map.get(head);
//    }

    public Node copyRandomList(Node head) {
        Node curr = head;
        Node rand = null;
        while (curr != null) {
            Node currNext = curr.next;
            rand = new Node(curr.val);
            curr.next = rand;
            rand.next = currNext;
            curr = rand.next;
        }

        curr = head;
        while (curr != null) {
            Node random = null;
            if (curr.random != null)
                random = curr.random.next;
            curr.next.random = random;
            curr = curr.next.next;
        }

        Node randomHead = head.next;
        rand = randomHead;
        curr = head;
        Node org = curr;
        while (curr != null) {
            Node currNextNext = curr.next.next;
            Node randNextNext = rand.next == null ? null : rand.next.next;
            org.next = currNextNext;
            rand.next = randNextNext;
            org = org.next;
            rand = rand.next;
            curr = currNextNext;
        }
        return randomHead;
    }

    public static void main(String[] args) {
        Node seven = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        seven.next = thirteen;
        seven.random = null;
        thirteen.next = eleven;
        thirteen.random = ten;
        eleven.next = ten;
        eleven.random = thirteen;
        ten.next = null;
        ten.random = seven;
        print(seven);
        print(new CopyUsingRandomPointer().copyRandomList(seven));
    }

    private static void print(Node seven) {
        while (seven != null) {
            System.out.println(seven.val);
            System.out.print("random:");
            if (seven.random == null) {
                System.out.println("null");
            } else
                System.out.println(seven.random.val);
            seven = seven.next;
        }
    }


}
