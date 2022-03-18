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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Don't create tree if there are no root nodes
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode();
        mergeTreesAux(root1, root2, newRoot);
        return newRoot;
    }

    private void mergeTreesAux(TreeNode node1, TreeNode node2, TreeNode nodenew) {
        if (node1 != null && node2 != null) {
            nodenew.val = node1.val + node2.val;
        } else if (node1 != null) {
            nodenew.val = node1.val;
        } else if (node2 != null) {
            nodenew.val = node2.val;
        } else {
            // Both null
            return;
        }

        // If we are here, at least one of the nodes is not null
        // This does not guarantee that there are children though...

        // This does, but it's an ugly condition...
        if ((node1 != null && node1.left != null) || (node2 != null && node2.left != null)) {
            nodenew.left = new TreeNode();
            mergeTreesAux(node1 != null ? node1.left : null, node2 != null ? node2.left : null, nodenew.left);
        }
        if ((node1 != null && node1.right != null) || (node2 != null && node2.right != null)) {
            nodenew.right = new TreeNode();
            mergeTreesAux(node1 != null ? node1.right : null, node2 != null ? node2.right : null, nodenew.right);
        }
    }
}