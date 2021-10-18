# Author: Chris Hoerle
# Date: 08/09/2021

'''
	Implement strStr().
	Return the index of the first occurrence of needle in haystack, 
	or -1 if needle is not part of haystack.
	Clarification:
	What should we return when needle is an empty string? 
	This is a great question to ask during an interview. For the purpose 
	of this problem, we will return 0 when needle is an empty string. 
	This is consistent to C's strstr() and Java's indexOf().

 	Examples:
	Input: haystack = "hello", needle = "ll"
	Output: 2

	Input: haystack = "aaaaa", needle = "bba"
	Output: -1

	Input: haystack = "", needle = ""
	Output: 0

	Constraints:
	0 <= haystack.length, needle.length <= 5 * 104
	haystack and needle consist of only lower-case English characters.
'''

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        for i in range(len(haystack)):
            # search every two characters in haystack
            if haystack[i:i + len(needle)] == needle:
                return i
        return -1 