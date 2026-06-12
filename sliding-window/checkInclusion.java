/*
Problem: Permutation in String
Platform: LeetCode 567
Approach: Sliding Window + Frequency Array

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Frequency of s1 and first window of s2
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (java.util.Arrays.equals(freq1, freq2)) {
            return true;
        }

        // Sliding window
        for (int i = n; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;          // add new character
            freq2[s2.charAt(i - n) - 'a']--;      // remove old character

            if (java.util.Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
