/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode prev = null;
        ListNode curr = head;
        while (list1 != null || list2 != null) {
            int newval;
            if (list2 == null) {
                newval = list1.val;
                list1 = list1.next;
            } else if (list1 == null) {
                newval = list2.val;
                list2 = list2.next;
            } else {
                if (list1.val < list2.val) {
                    newval = list1.val;
                    list1 = list1.next;
                } else {
                    newval = list2.val;
                    list2 = list2.next;
                }
            }

            curr.val = newval;
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;
            curr = new ListNode();
        }

        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Input: list1 = [1,2,4], list2 = [1,3,4]
        // Output: [1,1,2,3,4,4]
        // System.out.println();
        // Input: list1 = [], list2 = []
        // Output: []
        // System.out.println();
        // Input: list1 = [], list2 = [0]
        // Output: [0]
        // System.out.println();
    }
}
