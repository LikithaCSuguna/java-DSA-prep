/*
Problem: Remove Linked List Elements
Platform: LeetCode 203
Approach: Iterative Traversal

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
