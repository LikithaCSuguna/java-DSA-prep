/*
Problem: Intersection of Two Linked Lists
Platform: LeetCode 160
Approach: Two Pointer Technique

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1; // intersection node or null
    }
}
