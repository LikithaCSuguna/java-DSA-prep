/*

Problem: Largest Element in an Array
Platform: GFG
Approach: Linear Traversal

Time Complexity: O(n)
Space Complexity: O(1)
*/

package arrays;
public class LargestElement {
    // Method to find the largest element
    public static int findLargest(int[] arr) {
        int max = arr[0]; // assume first element is max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // update max
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        int result = findLargest(arr);
        System.out.println("Largest element: " + result);
    }
}