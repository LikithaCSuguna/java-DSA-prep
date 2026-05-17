/*
Problem: Intersection of Two Arrays
Platform: LeetCode
Approach: HashSet

Time Complexity: O(n + m)
Space Complexity: O(n)
*/

package sorting;

import java.util.*;

class IntersectionOfTwoArrays {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        // Store elements of nums1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check intersection with nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert result set to array
        int[] result = new int[resultSet.size()];
        int index = 0;

        for (int num : resultSet) {
            result[index++] = num;
        }

        // Print result
        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
