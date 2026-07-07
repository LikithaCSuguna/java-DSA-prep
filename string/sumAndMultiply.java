/*
Problem: Sum and Multiply
Platform: LeetCode
Approach: String Filtering

Time Complexity: O(d)
Space Complexity: O(d)
*/

class Solution {
public:
    long long sumAndMultiply(int n) {
        string s = to_string(n);
        string digits = "";
        for (char c : s) {
            if (c != '0') digits += c;
        }
        if (digits.empty()) return 0;
        
        long long x = stoll(digits);
        long long sum = 0;
        for (char c : digits) sum += (c - '0');
        
        return x * sum;
    }
};
