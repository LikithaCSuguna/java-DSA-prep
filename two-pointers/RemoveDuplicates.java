/*
Problem: Remove Duplicates from Sorted Array
Platform: LeetCode
Approach: Two Pointer Technique

Time Complexity: O(n)
Space Complexity: O(1)
*/

package arrays;

public class RemoveDuplicates{
    public static int removeDuplicates(int[] nums){
        if (nums.length == 0) return 0;

        int i = 0; // pointer for unique elements

        // Traverse array using second pointer
        for (int j = 1; j < nums.length; j++) {

            // If new unique element is found
            if (nums[j] != nums[i]) {
                i++; // move pointer forward
                nums[i] = nums[j]; // place unique element
            }
        }
        return i + 1; // length of unique elements
    }
    public static void main(String[]args) {

        // Input sorted array
        int[] numbers = {1, 1, 2, 2, 3, 4, 4};

        // Call method
        int newLength = removeDuplicates(numbers);

        // Print result
        System.out.println("Number of unique elements: " + newLength);

        System.out.print("Updated array: ");
        for (int index = 0; index < newLength; index++) {
            System.out.print(numbers[index] + " ");
        }
    }
}
