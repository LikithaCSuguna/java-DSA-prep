/*
Problem: Maximum Depth of Binary Tree
Platform: LeetCode
Approach: Recursion (DFS)

Time Complexity: O(n)
Space Complexity: O(h)
*/

class Solution {

    public int maxDepth(TreeNode root) {

        // Base Case
        if (root == null) {
            return 0;
        }

        // Find depth of left subtree
        int leftDepth = maxDepth(root.left);

        // Find depth of right subtree
        int rightDepth = maxDepth(root.right);

        // Return maximum depth
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
