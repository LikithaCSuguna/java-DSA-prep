/*
Problem: Best Time to Buy and Sell Stock
Platform: LeetCode
Approach: Greedy

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxProfit(int[] prices){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices){

            // Update minimum buying price
            minPrice = Math.min(minPrice, price);

            // Update maximum profit
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
