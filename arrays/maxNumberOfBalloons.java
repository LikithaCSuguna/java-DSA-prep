/*

Problem: Maximum Number of Balloons
Platform: LeetCode
Approach: Character Frequency Count

Time Complexity: O(n)
Space Complexity: O(1)

*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }
        return Math.min(
                Math.min(freq['b' - 'a'], freq['a' - 'a']),
                Math.min(
                    freq['l' - 'a'] / 2,
                    Math.min(freq['o' - 'a'] / 2, freq['n' - 'a'])
                )
        );
    }
}
