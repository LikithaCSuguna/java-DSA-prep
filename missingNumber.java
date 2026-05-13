/*
Problem: Missing Number
Platform: LeetCode
Approach: Sum Formula

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int missingNumber(int[] nums) {

        int n = nums.length;

        // Sum from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Sum of array elements
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        // Missing number
        return expectedSum - actualSum;
    }
}
