/*
Problem: Find Right Interval
Platform: LeetCode
Approach: Binary Search + Sorting

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        
        int[][] startPoints = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            startPoints[i][0] = intervals[i][0];
            startPoints[i][1] = i;
        }
        
        Arrays.sort(startPoints, (a, b) -> a[0] - b[0]);  
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            
            int left = 0;
            int right = n - 1;
            int ans = -1;         
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (startPoints[mid][0] >= end) {
                    ans = startPoints[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = ans;
        }
        
        return result;
    }
}
