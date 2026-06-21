/*

Problem: Maximum Ice Cream Bars
Platform: LeetCode
Approach: Counting Sort + Greedy

Time Complexity: O(n + maxCost)
Space Complexity: O(maxCost)

*/

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 100000;
        int[] count = new int[maxCost + 1];
        
        for (int cost : costs) {
            count[cost]++;
        }
        
        int bars = 0;
        for (int cost = 1; cost <= maxCost && coins > 0; cost++) {
            if (count[cost] == 0) continue;
            int canBuy = Math.min(count[cost], coins / cost);
            bars += canBuy;
            coins -= canBuy * cost;
        }
        
        return bars;
    }
}
