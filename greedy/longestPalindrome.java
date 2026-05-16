/*
Problem: Longest Palindrome
Platform: LeetCode
Approach: Hashing + Greedy

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int longestPalindrome(String s) {

        int[] freq = new int[128];
        
        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int length = 0;
        boolean oddFound = false;

        // Build palindrome length
        for (int count : freq) {

            // Add even part
            length += (count / 2) * 2;

            // Check if any odd frequency exists
            if (count % 2 == 1) {
                oddFound = true;
            }
        }
        if (oddFound) {
            length += 1;
        }

        return length;
    }
}
