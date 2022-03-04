/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersAux(root, 0);
    }

    // (Might not fit in int bc no unsigned lol)
    private int sumNumbersAux(TreeNode currnode, int acc_number) {
        // It's easier to have the nullcheck here instead of adding several ifs in the last line.
        if (currnode == null) {
            // Not an actual node, just return 0 to collapse this branch of the call stack
            return 0;
        }

        int new_acc_number = acc_number * 10 + currnode.val;

        // Check if this is a leaf
        if (currnode.left == null && currnode.right == null) {
            return new_acc_number;
        }

        // If not a leaf, keep accumulating
        return sumNumbersAux(currnode.left, new_acc_number) + sumNumbersAux(currnode.right, new_acc_number);
    }
}