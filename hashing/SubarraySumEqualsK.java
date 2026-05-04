/*
Problem: Subarray Sum Equals K
Platform: LeetCode
Approach: Prefix Sum + HashMap

Time Complexity: O(n)
Space Complexity: O(n)
*/

package arrays;

import java.util.HashMap;
class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to handle subarrays starting from index 0
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println(count);
    }
}
