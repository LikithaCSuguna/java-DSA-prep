/*

 Problem: Sum of Consecutive Natural Numbers
 Platform: GeeksforGeeks
 Approach: Odd Divisor Counting 

 Time Complexity: O(sqrt(n))
 Space Complexity: O(1)

 */

class Solution {
    public int getCount(int n) {
        int oddDivisors = 0;
        while (n % 2 == 0) {
            n /= 2;
        }
        for (int i = 1; (long) i * i <= n; i++) {
            if (n % i == 0) {
                oddDivisors++;
                if (i != n / i) {
                    oddDivisors++;
                }
            }
        }
        return oddDivisors - 1;
    }
}
