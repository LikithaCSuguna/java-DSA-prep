/*
Problem: Maximum Average Subarray I
Platform: LeetCode
Approach: Sliding Window

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        // Calculate first window sum
        long windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        long maxSum = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {

            windowSum += nums[i] - nums[i - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}
