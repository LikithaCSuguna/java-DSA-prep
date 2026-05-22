/*
Problem: Kth Largest Element in a Stream
Platform: LeetCode
Approach: Min Heap (Priority Queue)

Time Complexity:
- Constructor: O(n log k)
- add(): O(log k)

Space Complexity: O(k)
*/

package heap;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }


    public int add(int val) {
        minHeap.offer(val);

        // Keep only k largest elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        // Top element is kth largest
        return minHeap.peek();
    }
}

