/* 

Problem: Count Pairs Divisible By K 
Approach: Hashing 
Platform: GeeksforGeeks 

Time Complexity: O(n)
Space Complexity: O(k)

*/
class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] freq = new int[k];
        int count = 0;
        for (int num : arr) {
            int rem = num % k;
            int comp = (k - rem) % k;
            count += freq[comp];
            freq[rem]++;
        }
        return count;
    }
}
