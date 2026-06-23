/*
Problem: Maximum Number of People That Can Be Defeated
Platform: GeeksForGeeks
Approach: Binary Search 

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    int maxPeopleDefeated(int p) {
        long long left = 0, right = 1500;

        while (left < right) {
            long long mid = left + (right - left + 1) / 2;
            long long sum = mid * (mid + 1) * (2 * mid + 1) / 6;

            if (sum <= (long long)p)
                left = mid;
            else
                right = mid - 1;
        }

        return (int)left;
    }
};
