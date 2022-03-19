import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new LinkedList<>();

        inorderTraversalAux(root, output);

        return output;
    }

    private void inorderTraversalAux(TreeNode node, List<Integer> output) {
        if (node == null) {
            return;
        }

        // in order traversal: left, self, right
        inorderTraversalAux(node.left, output);
        output.add(node.val);
        inorderTraversalAux(node.right, output);
    }
}