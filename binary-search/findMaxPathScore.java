/*

Problem: Maximum Path Score with Recovery Cost Budget
Platform: LeetCode
Approach: Binary Search

Time Complexity: O(E log E) 
Space Complexity: O(V + E)

*/

import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        if (edges.length == 0) return -1;
        TreeSet<Integer> costSet = new TreeSet<>();
        for (int[] e : edges) costSet.add(e[2]);
        List<Integer> costs = new ArrayList<>(costSet);

        int lo = 0, hi = costs.size() - 1;
        int answer = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int threshold = costs.get(mid);
            if (canReachWithMinEdge(n, edges, online, k, threshold)) {
                answer = threshold;  
                lo = mid + 1;
            } else {
                hi = mid - 1;    
            }
        }

        return answer;
    }
    private boolean canReachWithMinEdge(int n, int[][] edges, boolean[] online, long k, int threshold) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            if (e[2] >= threshold) {
                graph.get(e[0]).add(new int[]{e[1], e[2]});
            }
        }
        long[] best = new long[n];
        Arrays.fill(best, -1); 
        long result = dfs(0, n - 1, graph, online, best);

        return result != Long.MAX_VALUE && result <= k;
    }
    private long dfs(int node, int target, List<List<int[]>> graph, boolean[] online, long[] best) {
        if (node == target) return 0;

        if (best[node] != -1) return best[node];

        long minCost = Long.MAX_VALUE;
        if (node == 0 || online[node]) {
            for (int[] next : graph.get(node)) {
                int neighbor = next[0];
                long edgeCost = next[1];

                long sub = dfs(neighbor, target, graph, online, best);
                if (sub != Long.MAX_VALUE) {
                    minCost = Math.min(minCost, edgeCost + sub);
                }
            }
        }

        best[node] = minCost;
        return minCost;
    }
}
