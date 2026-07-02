/*

Problem: Divisible Group Sum
Platform: GeeksforGeeks
Approach: Dynamic Programming - Track reachable remainders modulo k

Time Complexity: O(n * k)
Space Complexity: O(k)

*/

class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        boolean[] dp = new boolean[k];
        for (int num : arr) {
            boolean[] newDp = dp.clone();
            int rem = num % k;
            if (rem == 0) return true;
            newDp[rem] = true;

            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    int newRem = (r + rem) % k;
                    if (newRem == 0) return true;
                    newDp[newRem] = true;
                }
            }
            dp = newDp;
        }
        return dp[0];
    }
}
