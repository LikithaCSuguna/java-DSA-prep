/*

 * Problem: Ransom Note
 * Platform: LeetCode
 * Approach: Frequency Count 

 * Time Complexity: O(m + n)
 * Space Complexity: O(1) 

 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) return false;
        }
        return true;
    }
}
