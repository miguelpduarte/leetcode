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
        HashMap<Integer, Integer> level_lowest_pos = new HashMap<>();
        HashMap<Integer, Integer> level_highest_pos = new HashMap<>();
        widthOfBinaryTreeAux(root, 0, 0, level_lowest_pos, level_highest_pos);

        // The minimum width is 1, which is just the root node.
        // Added here to not have to change the logic lower down since the edge case is covered by simply changing this default value
        int max_width = 1;
        for (int level : level_lowest_pos.keySet()) {
            if (!level_highest_pos.containsKey(level)) {
                continue;
            }

            int level_lowest = level_lowest_pos.get(level);
            int level_highest = level_highest_pos.get(level);

            // If lowest and highest have the same signum (both positive or both negative) then width = max - min + 1
            // If they have opposing signums, width = abs(low) + high
            int level_width = 0;

            if (Integer.signum(level_lowest) * Integer.signum(level_highest) == 1) {
                level_width = level_highest - level_lowest + 1;
            } else {
                level_width = Math.abs(level_lowest) + level_highest;
            }

            if (level_width > max_width) {
                max_width = level_width;
            }
        }

        return max_width;
    }

    private void widthOfBinaryTreeAux(TreeNode curr, int level, int curr_pos, HashMap<Integer, Integer> level_lowest_pos, HashMap<Integer, Integer> level_highest_pos) {
        int my_level_lowest_pos = level_lowest_pos.getOrDefault(level, Integer.MAX_VALUE);
        if (curr_pos < my_level_lowest_pos) {
            level_lowest_pos.put(level, curr_pos);
        }
        int my_level_highest_pos = level_highest_pos.getOrDefault(level, Integer.MIN_VALUE);
        if (curr_pos > my_level_highest_pos) {
            level_highest_pos.put(level, curr_pos);
        }

        // Calculating new positions from current position when going down a level
        // If curr_pos is negative: left is *2, right is *2+1
        // If curr_pos is positive: left is *2-1, right is *2
        // So we can always do + (0,1) and if positive just subtract 1 to each. This is pos_shift

        // first level edgecase: 0 has to be considered as positive for left and negative for right, so the comparison has to be done inside each if

        if (curr.left != null) {
            int pos_shift = 0;
            if (curr_pos >= 0) {
                pos_shift = -1;
            }
            widthOfBinaryTreeAux(curr.left, level + 1, curr_pos * 2 + pos_shift, level_lowest_pos, level_highest_pos);
        }
        if (curr.right != null) {
            int pos_shift = 0;
            if (curr_pos > 0) {
                pos_shift = -1;
            }
            widthOfBinaryTreeAux(curr.right, level + 1, curr_pos * 2 + 1 + pos_shift, level_lowest_pos, level_highest_pos);
        }
    }
}