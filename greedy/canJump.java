/*
Problem: Jump Game
Platform: LeetCode
Approach: Greedy 

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index is not reachable
            if (i > maxReach) {
                return false;
            }

            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            // Last index can be reached
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
