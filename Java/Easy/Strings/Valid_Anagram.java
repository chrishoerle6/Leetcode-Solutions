// Author: Chris Hoerle
// Date: 08/09/2021

/* 
	Given two strings s and t, return true if t is an anagram of s, and 
	false otherwise.

 	Examples:
	Input: s = "anagram", t = "nagaram"
	Output: true

	Input: s = "rat", t = "car"
	Output: false
 
	Constraints:
	1 <= s.length, t.length <= 5 * 104
	s and t consist of lowercase English letters.    
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }  
        
        char charArray1[] = s.toCharArray();
        char charArray2[] = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        
        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }
        return true;
    }
}