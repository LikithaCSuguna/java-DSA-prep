/*
Problem: Two Sum
Platform: LeetCode
Approach: Brute Force

Time Complexity: O(n^2)
Space Complexity: O(1)
*/
package arrays;
class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}