/*
Problem: Sum and Multiply
Platform: LeetCode
Approach: String Filtering

Time Complexity: O(d)
Space Complexity: O(d)
*/


class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        StringBuilder digits = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c != '0') {
                digits.append(c);
            }
        }
        
        if (digits.length() == 0) return 0;
        
        long x = Long.parseLong(digits.toString());
        long sum = 0;
        for (char c : digits.toString().toCharArray()) {
            sum += (c - '0');
        }
        
        return x * sum;
    }
}
