/*
Problem: Basic Calculator
Platform: LeetCode 224

Approach:
- Use a stack to handle parentheses.
- Maintain current result and sign.
- When '(' is encountered, store current result and sign.
- When ')' is encountered, evaluate the current expression with the stored values.
- Build multi-digit numbers and add them immediately using the current sign.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
                i--;
            }
            else if (ch == '+') {
                sign = 1;
            }
            else if (ch == '-') {
                sign = -1;
            }
            else if (ch == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            }
            else if (ch == ')') {
                int prevSign = st.pop();
                int prevResult = st.pop();
                result = prevResult + prevSign * result;
            }
        }

        return result;
    }
}
