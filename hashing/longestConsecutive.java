/*
Problem: Longest Consecutive Sequence
Platform: LeetCode
Approach: HashSet

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;
class Solution {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store all elements in HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Start only if it is the beginning of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
