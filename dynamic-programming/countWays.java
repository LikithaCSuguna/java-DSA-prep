/*

Problem: Numbers with Given Digit Sum
Platform: GeeksforGeeks
Approach: Use Dynamic Programming.

Time Complexity: O(n * sum * 10)
Space Complexity: O(n * sum)

*/

class Solution {
    public int countWays(int n, int sum) {
        if (sum > 9 * n) return -1;
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                for (int d = 0; d <= 9; d++) {
                    if (s >= d) {
                        dp[i][s] += dp[i - 1][s - d];
                    }
                }
            }
        }
        int ans = 0;
        for (int first = 1; first <= 9; first++) {
            if (sum >= first) {
                ans += dp[n - 1][sum - first];
            }
        }
        return ans == 0 ? -1 : ans;
    }
}
