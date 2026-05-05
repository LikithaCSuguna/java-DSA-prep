/*
Problem: Majority Element
Platform: LeetCode
Approach: Boyer-Moore Voting Algorithm

Time Complexity: O(n)
Space Complexity: O(1)
*/

package arrays;

class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int candidate = 0;
        int count = 0;
        // Find potential candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num; // choose new candidate
            }

            if (num == candidate) {
                count++; // same element increase count
            } else {
                count--; 
            }
        }
        System.out.println(candidate);
    }
}
