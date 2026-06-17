/* 
   Problem: Integer Break
   Platform: GeeksforGeeks
   Approach: Dynamic Programming

   Time Complexity: O(n^2)
   Space Complexity: O(n) 

*/

class Solution {
    public int maxProduct(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int best = i; 
            for (int j = 1; j < i; j++) {
                best = Math.max(best, j * dp[i - j]);
            }
            dp[i] = best;
        }
        int ans = 0;
        for (int k = 1; k < n; k++) {
            ans = Math.max(ans, k * dp[n - k]);
        }
        return ans;
    }
}
