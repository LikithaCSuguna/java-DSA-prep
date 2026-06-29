/*

 Problem: Number of Strings Appearing as Substrings
 Platform: Leetcode
 Approach: Linear Scan using Built-in contains
 
 Time Complexity: O(n * m) 
 Space Complexity: O(1)
 
 */
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }
}
