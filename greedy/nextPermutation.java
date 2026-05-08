/*
Problem: Next Permutation
Platform: LeetCode
Approach: Greedy + Two Pointer

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // Find first decreasing element from right
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If no breakpoint found, reverse entire array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Find next greater element from right
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Reverse right half
        reverse(nums, index + 1, n - 1);
    }

    // Function to swap elements
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Function to reverse array
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
