import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            Integer arr1_count = map1.get(num);
            if (arr1_count != null && arr1_count > 0) {
                result.add(num);
                map1.put(num, arr1_count - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Input: nums1 = [1,2,2,1], nums2 = [2,2]
        // Output: [2,2]
        assert Arrays.equals(s.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2, 2});
        // Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        // Output: [4,9]
        // Explanation: [9,4] is also accepted.
        assert Arrays.equals(s.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}), new int[]{4, 9});
    }
}