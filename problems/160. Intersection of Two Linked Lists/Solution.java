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
        HashSet<ListNode> seen_nodes = new HashSet<>();

        ListNode currA = headA;
        while (currA != null) {
            seen_nodes.add(currA);
            currA = currA.next;
        }

        ListNode currB = headB;
        while(currB != null) {
            if (seen_nodes.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }

        return null;
    }
}