/*

Problem: Find the Safest Path in a Grid
Platform: LeetCode
Approach: Multi-source BFS (for Manhattan distances) + Dijkstra-style Widest Path (max-heap)

Time Complexity: O(n^2 log n)
Space Complexity: O(n^2)

*/

import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        int[][] safety = new int[n][n];
        for (int[] row : safety) Arrays.fill(row, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        safety[0][0] = dist[0][0];
        pq.offer(new int[]{dist[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0], r = cur[1], c = cur[2];
            
            if (val < safety[r][c]) continue; 
            if (r == n - 1 && c == n - 1) return val; 
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int candidate = Math.min(val, dist[nr][nc]);
                    if (candidate > safety[nr][nc]) {
                        safety[nr][nc] = candidate;
                        pq.offer(new int[]{candidate, nr, nc});
                    }
                }
            }
        }
        
        return safety[n - 1][n - 1];
    }
}
