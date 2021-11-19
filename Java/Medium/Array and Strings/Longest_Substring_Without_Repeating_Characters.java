// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given a string s, find the length of the longest substring without 
	repeating characters.

	Examples:
	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.

	Input: s = "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.

	Input: s = "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3.
	Notice that the answer must be a substring, "pwke" is a subsequence 
	and not a substring.

	Input: s = ""
	Output: 0
	 
	Constraints:
	0 <= s.length <= 5 * 104
	s consists of English letters, digits, symbols and spaces.	
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1; 
        }
        
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, set.size());
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}