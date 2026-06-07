/*
Problem: Increasing Triplet Subsequence
Platform: LeetCode 334
Approach: Greedy

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } 
            else if (num <= second) {
                second = num;
            } 
            else {
                return true; // num > first and num > second
            }
        }

        return false;
    }
}
