/*
Problem: Redundant Connection
Platform: LeetCode
Approach: Union Find (Disjoint Set)

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    int[] parent;

    // Find parent with path compression
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // Union operation
    public boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        // Cycle detected
        if (parentA == parentB) {
            return false;
        }

        parent[parentA] = parentB;
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];

        // Initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Process edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // If union fails, this edge is redundant
            if (!union(u, v)) {
                return edge;
            }
        }

        return new int[0];
    }
}
