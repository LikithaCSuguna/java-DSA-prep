/*
Problem: Find the Difference
Platform: LeetCode 389
Approach: XOR of all characters

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char x : s.toCharArray()) c^=x;
        for (char x : t.toCharArray()) c^=x;
        return c;
    }
}
