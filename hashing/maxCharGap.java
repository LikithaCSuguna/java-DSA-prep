/*

Problem: Maximum Gap Between Identical Characters
Platform: GFG
Approach: First and Last Occurrence Tracking

Time Complexity: O(n)
Space Complexity: O(1)

*/

class Solution {
    public int maxCharGap(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }
        int maxGap = -1;
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] != first[i]) {
                int gap = last[i] - first[i] - 1;
                maxGap = Math.max(maxGap, gap);
            }
        }
        return maxGap;
    }
}
