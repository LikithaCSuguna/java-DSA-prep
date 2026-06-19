/*

Problem: Find the Highest Altitude
Platform: LeetCode 1732
Approach: Prefix Sum

Time Complexity: O(n)
Space Complexity: O(1)

*/

class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            altitude += g;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}
