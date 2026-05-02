/*

Problem: Move Zeroes
Platform: LeetCode
Approach: Two Pointer (Swap Method)

Time Complexity: O(n)
Space Complexity: O(1)

*/

package arrays;

public class MoveZeroes {
    // Method to move all zeroes to the end
    public static void moveZeroes(int[] nums) {
        
        int left = 0; // position to place next non-zero element
        
        // Traverse array with right pointer
        for (int right = 0; right < nums.length; right++) {
            
            // If current element is non-zero
            if (nums[right] != 0) { 
                // Swap current element with element at left
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                // Move left pointer forward
                left++;
            }
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        // Print the updated array
        System.out.print("Output: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
