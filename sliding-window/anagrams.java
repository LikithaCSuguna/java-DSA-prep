/*
Problem: Find All Anagrams in a String
Platform: LeetCode 
Approach: Sliding Window + Frequency Array

Time Complexity: O(n) 
Space Complexity: O(1)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) return result;

        int[] pCount = new int[26];
        int[] wCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            wCount[s.charAt(i) - 'a']++;
        }

        if (matches(pCount, wCount)) result.add(0);

        int windowLen = p.length();
        for (int right = windowLen; right < s.length(); right++) {
            int left = right - windowLen;

            wCount[s.charAt(right) - 'a']++;
            wCount[s.charAt(left)  - 'a']--;

            if (matches(pCount, wCount)) result.add(left + 1);
        }

        return result;
    }

    private boolean matches(int[] pCount, int[] wCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != wCount[i]) return false;
        }
        return true;
    }
}
