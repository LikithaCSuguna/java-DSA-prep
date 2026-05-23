/*
Problem: Subsets
Platform: LeetCode
Approach: Backtracking

Time Complexity: O(2^n)
Space Complexity: O(2^n)
*/

package backtracking;

import java.util.*;

class Subsets {

    public static void findSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Generate subsets
        for (int i = index; i < nums.length; i++) {

            // Include current element
            current.add(nums[i]);

            // Recursive call
            findSubsets(nums, i + 1, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();

        findSubsets(nums, 0, new ArrayList<>(), result);

        System.out.println(result);
    }
}
