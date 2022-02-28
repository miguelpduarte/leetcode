import java.util.HashMap;

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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Long> level_lowest_pos = new HashMap<>();
        HashMap<Integer, Long> level_highest_pos = new HashMap<>();
        widthOfBinaryTreeAux(root, 0, 0, level_lowest_pos, level_highest_pos);

        // The minimum width is 1, which is just the root node.
        // This could be 0, since it would be replaced by the single node anyway (0 - 0 + 1).
        long max_width = 1;
        for (int level : level_lowest_pos.keySet()) {
            if (!level_highest_pos.containsKey(level)) {
                continue;
            }

            // Now both lowest and highest are always positive. Just need to do high - low + 1.
            long level_width = level_highest_pos.get(level) - level_lowest_pos.get(level) + 1;

            if (level_width > max_width) {
                max_width = level_width;
            }
        }

        return (int) max_width;
    }

    private void widthOfBinaryTreeAux(TreeNode curr, int level, long curr_pos, HashMap<Integer, Long> level_lowest_pos, HashMap<Integer, Long> level_highest_pos) {
        long my_level_lowest_pos = level_lowest_pos.getOrDefault(level, Long.MAX_VALUE);
        if (curr_pos < my_level_lowest_pos) {
            level_lowest_pos.put(level, curr_pos);
        }
        long my_level_highest_pos = level_highest_pos.getOrDefault(level, Long.MIN_VALUE);
        if (curr_pos > my_level_highest_pos) {
            level_highest_pos.put(level, curr_pos);
        }

        // Calculating new positions from current position when going down a level
        // Just multiply by 2 and for the right node add 1
        // 0 will have (0,1) as child; 1 will have (2,3); 2 will have (4,5). Simpler than using negative values.

        if (curr.left != null) {
            widthOfBinaryTreeAux(curr.left, level + 1, curr_pos * 2, level_lowest_pos, level_highest_pos);
        }
        if (curr.right != null) {
            widthOfBinaryTreeAux(curr.right, level + 1, curr_pos * 2 + 1, level_lowest_pos, level_highest_pos);
        }
    }
}