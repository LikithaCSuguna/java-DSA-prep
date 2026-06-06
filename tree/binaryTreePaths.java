/*
Problem: Binary Tree Paths
Platform: LeetCode 257
Approach: DFS (Depth First Search)

Time Complexity: O(n)
Space Complexity: O(h)
*/


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }
    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        path += node.val;
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        path += "->";
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}
