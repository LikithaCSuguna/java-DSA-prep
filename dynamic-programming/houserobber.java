/*
Problem: House Robber
Platform: LeetCode
Approach: Dynamic Programming (1D DP)

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case
        if (n == 1) return nums[0];

        // dp[i] = maximum money robbed till house i
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill DP array
        for (int i = 2; i < n; i++) {

            // Either rob current house OR skip current house
            dp[i] = Math.max(
                    nums[i] + dp[i - 2],
                    dp[i - 1]
            );
        }
        return dp[n - 1];
    }
}
