/*
Problem: Zigzag Conversion
Platform: LeetCode
Approach: Simulation using StringBuilder for each row

Time Complexity: O(n)
Space Complexity: O(n)

*/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean down = true;
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            if (currRow == 0) {
                down = true;
            } else if (currRow == numRows - 1) {
                down = false;
            }
            currRow += down ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }
}
