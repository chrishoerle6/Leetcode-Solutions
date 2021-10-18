// Author: Chris Hoerle
// Date: 08/09/2021

/*
	Write a function to find the longest common prefix string amongst an 
	array of strings. If there is no common prefix, return an empty string "".

 	Examples:
	Input: strs = ["flower","flow","flight"]
	Output: "fl"

	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
 
	Constraints:
	1 <= strs.length <= 200
	0 <= strs[i].length <= 200
	strs[i] consists of only lower-case English letters.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        
        if (strs == null || strs.length == 0) {
            return longestCommonPrefix;
        }
        
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (index >= strs[j].length() || c != strs[j].charAt(index)) {
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix += c;
            index++;
        }
        return longestCommonPrefix;
    }
}