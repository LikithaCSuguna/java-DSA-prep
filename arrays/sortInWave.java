/*

Problem: Sort in Wave Form
Platform: GeeksforGeeks
Approach: Swap Adjacent Pairs

Time Complexity: O(n)
Space Complexity: O(1)

*/

class Solution {
    public void sortInWave(int arr[]) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
