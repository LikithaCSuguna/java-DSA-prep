/*
Problem: Maximum Sum Circular Subarray
Platform: LeetCode
Approach: Kadane's Algorithm

Time Complexity: O(n)
Space Complexity: O(1)
*/

package queue;
class MaximumCircularSubarraySum {

    public static void main(String[] args) {

        int[] nums = {5, -3, 5};

        int totalSum = 0;

        int currMax = 0;
        int maxSum = nums[0];

        int currMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            // Maximum Subarray Sum
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            // Minimum Subarray Sum
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        int result;

        // If all elements are negative
        if (maxSum < 0) {
            result = maxSum;
        } else {
            result = Math.max(maxSum, totalSum - minSum);
        }
        System.out.println("Maximum Circular Subarray Sum: " + result);
    }
}
