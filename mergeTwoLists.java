/*
Problem: Merge Two Sorted Lists
Platform: LeetCode
Approach: Iterative Linked List Merge

Time Complexity: O(n + m)
Space Complexity: O(1)
*/

package linked_list;
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node to store merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return merged list
        return dummy.next;
    }
}
