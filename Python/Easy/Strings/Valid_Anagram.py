## Author: Chris Hoerle
## Date: 08/09/2021

'''
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
'''

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        list1 = list(s)
        list2 = list(t)
        list1.sort()
        list2.sort()
        
        for i in range(len(list1)):
            if list1[i] != list2[i]:
                return False
        
        return True