/*
Problem: Baseball Game
Platform: LeetCode
Approach: Stack

Time Complexity: O(n)
Space Complexity: O(n)
*/

package arrays;
import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String op : operations) {

            // Remove previous score
            if (op.equals("C")) {
                stack.pop();
            }

            // Double previous score
            else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            }

            // Sum of previous two scores
            else if (op.equals("+")) {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
            }

            // Integer value
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        // Find total score
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}
