## Author: Chris Hoerle
## Date: 08/09/2021

'''
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
'''

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        longestCommonPrefix = ""
        
        if strs == None or strs == 0:
            return longestCommonPrefix
        
        index = 0
        for i in range(len(strs[0])):
            char = strs[0][i]
            for j in range(1, len(strs)):
                if index >= len(strs[j]) or char != strs[j][index]:
                    return longestCommonPrefix
            longestCommonPrefix += char
            index += 1
        
        return longestCommonPrefix