/*
Problem: Find the Number of Subsequences With Equal GCD
Platform: LeetCode
Approach: Dynamic Programming

Time Complexity: O(n * V^2), where n = nums.length and V = max(nums)
Space Complexity: O(V^2)
*/

class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        final int V = 200;
        int[][] gcdTable = new int[V + 1][V + 1];
        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                gcdTable[i][j] = gcd(i, j);
            }
        }
        long[][] dp = new long[V + 1][V + 1];
        dp[0][0] = 1;

        for (int a : nums) {
            long[][] ndp = new long[V + 1][V + 1];
            for (int g1 = 0; g1 <= V; g1++) {
                for (int g2 = 0; g2 <= V; g2++) {
                    long val = dp[g1][g2];
                    if (val == 0) continue;
                    ndp[g1][g2] = (ndp[g1][g2] + val) % MOD;
                    int ng1 = gcdTable[g1][a];
                    ndp[ng1][g2] = (ndp[ng1][g2] + val) % MOD;
                    int ng2 = gcdTable[g2][a];
                    ndp[g1][ng2] = (ndp[g1][ng2] + val) % MOD;
                }
            }
            dp = ndp;
        }
        long ans = 0;
        for (int g = 1; g <= V; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
