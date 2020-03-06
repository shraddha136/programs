import java.util.*;

class MergeLL {
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        if (headOne == null && headTwo == null)
            return null;
        if (headOne == null)
            return headTwo;
        if (headTwo == null)
            return headOne;

        LinkedList head = null;
        LinkedList curr = head;
        while (headOne != null && headTwo != null) {
            if (headOne.value <= headTwo.value) {
                if (curr == null) {
                    curr = headOne;
                } else
                    curr.next = headOne;
                headOne = headOne.next;
            } else {
                if (curr == null)
                    curr = headTwo;
                else
                    curr.next = headTwo.next;
                headTwo = headTwo.next;
            }
            curr = curr.next;
        }

        if (headOne != null)
            curr.next = headOne;
        if (headTwo != null)
            curr.next = headTwo;
        return head.next;
    }
}


