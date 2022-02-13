import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> unique1 = new HashSet<>();
        for (int num: nums1) {
            unique1.add(num);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int num: nums2) {
            if (unique1.contains(num)) {
                result.add(num);
                unique1.remove(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        // Input: nums1 = [1,2,2,1], nums2 = [2,2]
        // Output: [2]
        System.out.println(Arrays.equals(s.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2}));
        // Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        // Output: [9,4]
        // Explanation: [4,9] is also accepted.
        System.out.println(Arrays.equals(s.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}), new int[]{9,4}));
    }
}
