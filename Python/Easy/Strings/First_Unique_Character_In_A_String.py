# Author: Chris Hoerle
# Date: 08/09/2021

''' 
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
'''

class Solution:
    def firstUniqChar(self, s: str) -> int:
        dictionary = {}
        for i in s:
            if i not in dictionary:
                dictionary[i] = 1
            else:
                dictionary[i] += 1
        
        for i in range(len(s)):
            if dictionary[s[i]] == 1:
                return i
        return -1