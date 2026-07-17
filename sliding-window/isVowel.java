/*

Problem: Maximum Number of Vowels in a Substring of Given Length
Platform: LeetCode 1456
Approach: Sliding Window

Time Complexity: O(n)
Space Complexity: O(1)

*/
class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i'  || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {

        int count = 0;
        for( int i = 0; i < k; i++ ){
             if (isVowel(s.charAt(i))) {
                count++;

        }
    }
    int maxVowels = count;
    for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            if (isVowel(s.charAt(i))) {
                count++;
            }
            maxVowels = Math.max(maxVowels, count);
        }
        return maxVowels;
}
}
