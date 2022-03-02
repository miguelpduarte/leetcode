import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;

        // Both pointers iterate over both lists, first one then the other (crossed, 1 does A->B, 2 does B->A)
        // This ensures that the intersection is found regardless of differing lengths.
        // If the intersection does not exist, both pointers will be equal at the end of the list (null) because len(a) + len(b) == len(b) + len(a)
        // Thus this works regardless of there being an intersection or not, and the lists having different size or not.
        while (curr1 != curr2) {
            curr1 = curr1 == null ? headB : curr1.next;
            curr2 = curr2 == null ? headA : curr2.next;
        }

        return curr1;
    }
}