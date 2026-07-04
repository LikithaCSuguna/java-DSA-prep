/*

Problem: Minimum Score of a Path Between Two Cities
Platform: LeetCode
Approach: BFS/DFS to find connected component

Time Complexity: O(n + m)
Space Complexity: O(n + m)

*/

class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int a = road[0], b = road[1], d = road[2];
            adj[a].add(new int[]{b, d});
            adj[b].add(new int[]{a, d});
        }
        
        boolean[] visited = new boolean[n + 1];
        int minScore = Integer.MAX_VALUE;
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        visited[1] = true;
        
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int[] edge : adj[cur]) {
                int next = edge[0], dist = edge[1];
                minScore = Math.min(minScore, dist);
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
        
        return minScore;
    }
}
