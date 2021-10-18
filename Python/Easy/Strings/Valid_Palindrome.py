# Author: Chris Hoerle
# Date: 08/09/2021

'''
	Given a string s, determine if it is a palindrome, considering 
	only alphanumeric characters and ignoring cases.

 	Examples:
	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.

	Input: s = "race a car"
	Output: false
	Explanation: "raceacar" is not a palindrome.
 

	Constraints:
	1 <= s.length <= 2 * 105
	s consists only of printable ASCII characters.
'''

import re 

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = re.sub('[\W_]+', '', s)
        s = s.lower()
        reverse = reversed(s)
        s_list = list(s)
        reverse_list = list(reverse)
        
        for i in range(len(s_list)):
            if s_list[i] != reverse_list[i]:
                return False
        return True
