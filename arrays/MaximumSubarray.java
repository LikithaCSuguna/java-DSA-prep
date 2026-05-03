/*

Problem: Maximum Subarray Sum
Platform: LeetCode 
Approach: Kadane’s Algorithm (Linear Traversal)

Time Complexity: O(n)
Space Complexity: O(1)

*/

package arrays;

public class MaximumSubarray{
    public static int maxSubArray(int[] nums){
        
        int maxSum = nums[0];   
        int currentSum = 0;     // running sum
        
        for(int num:nums){
            currentSum += num;
            
            // update maximum sum
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            // reset if sum becomes negative
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}
