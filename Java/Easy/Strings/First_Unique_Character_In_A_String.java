// Author: Chris Hoerle
// Date: 08/09/2021

/* 
    Given a string s, find the first non-repeating character in it and 
    return its index. If it does not exist, return -1.

    Examples:
    Input: s = "leetcode"
    Output: 0

    Input: s = "loveleetcode"
    Output: 2

    Input: s = "aabb"
    Output: -1
 
    Constraints:
    1 <= s.length <= 105
    s consists of only lowercase English letters.   
*/

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (!map.containsKey(character)) {
                map.put(character, i);
            }
            else {
                map.put(character, -1);
            }
        }
        
        // If min does not change, no unique characters, return -1
        int min = Integer.MAX_VALUE;
        
        for (char c: map.keySet()) {
            if (map.get(c) > -1 && map.get(c) < min) {
                min = map.get(c);    
            }  
        }
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}