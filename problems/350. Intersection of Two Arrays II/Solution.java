import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        System.out.println("map1 = " + map1);

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        System.out.println("map2 = " + map2);

        ArrayList<Integer> result = new ArrayList<>();
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                // Element present in both maps, take the min of both maps (count of common elements)
                int itemCount = Math.min(map1.get(key), map2.get(key));
                // And add the key count times
                for (int i = 0; i < itemCount; ++i) {
                    result.add(key);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
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