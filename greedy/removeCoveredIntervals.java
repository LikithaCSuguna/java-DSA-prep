/*

Problem: Remove Covered Intervals
Platform: LeetCode
Approach: Sort by start ascending

Time Complexity: O(n log n)
Space Complexity: O(log n) (sorting)

*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int count = 0;
        int maxEnd = 0; 
        for (int[] interval : intervals) {
            int end = interval[1];
            if (end > maxEnd) {
                count++;
                maxEnd = end;
            }
        }   
        return count;
    }
}
