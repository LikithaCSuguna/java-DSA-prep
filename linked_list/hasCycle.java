/*
Problem: Linked List Cycle
Platform: LeetCode 141
Approach: Floyd's Cycle Detection

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            if (slow == fast) {
                return true;           // Cycle found
            }
        }
        return false;                  // No cycle
    }
}
