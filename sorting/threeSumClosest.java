/*

Problem: 3Sum Closest
Platform: LeetCode
Approach: Sorting + Two Pointers

Time Complexity: O(n^2)
Space Complexity: O(1)

*/

class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Update closest if this sum is nearer to target

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                
                if (sum < target) {
                    left++;          // need bigger sum
                } else if (sum > target) {
                    right--;         // need smaller sum
                } else {
                    return sum;      // exact match
                }
            }
        }
        return closest;
    }
}
