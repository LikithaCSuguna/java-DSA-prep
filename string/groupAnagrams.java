/*
Problem: Group Anagrams
Platform: LeetCode
Approach: HashMap + Sorting

Time Complexity: O(n*k log k)
Space Complexity: O(n*k)

*/

package string;
import java.util.*;
class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        
        // Map to store sorted string
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            
            // Convert string to char array
            char[] ch = str.toCharArray();
            
            // Sort characters
            Arrays.sort(ch);
            
            // Create key from sorted characters
            String key = new String(ch);
            
            // If key not present, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // Add original string to list
            map.get(key).add(str);
        }
        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> result = groupAnagrams(strs);
        
        System.out.println(result);
    }
}
