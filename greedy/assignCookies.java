/*
Problem: Assign Cookies
Platform: LeetCode 
Approach: Greedy

Time Complexity: O(n log n + m log m)
Space Complexity: O(1) 
*/

package greedy;

import java.util.Arrays;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // sort children by greed 
        Arrays.sort(s); // sort cookies by size 

        int child = 0;  // pointer for children
        int cookie = 0; // pointer for cookies

        // try to satisfy each child with the smallest valid cookie
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // this cookie satisfies this child
                child++;
            }
            // move to next cookie regardless (used or too small)
            cookie++;
        }

        return child; // number of content children
    }
}
