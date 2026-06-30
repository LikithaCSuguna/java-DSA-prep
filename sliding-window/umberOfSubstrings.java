/*

Problem: Number of Substrings Containing All Three Characters
Platform: LeetCode
Approach: Sliding Window 

Time Complexity: O(n)
Space Complexity: O(1)

*/

class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            res += Math.min(last[0], Math.min(last[1], last[2])) + 1;
        }
        return res;
    }
}
