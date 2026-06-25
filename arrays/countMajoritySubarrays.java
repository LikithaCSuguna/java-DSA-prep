/*

 * Problem: Count Subarrays Where Majority Element is Target
 * Platform: LeetCode
 * Approach: Prefix Sum with Transformation

 * Time Complexity: O(n^2)
 * Space Complexity: O(n)

 */
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int count = 0;

        // For each subarray end j, count starts i where prefix[i] < prefix[j+1]
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (prefix[i] < prefix[j + 1]) {
                    count++;
                }
            }
        }

        return count;
    }
}
