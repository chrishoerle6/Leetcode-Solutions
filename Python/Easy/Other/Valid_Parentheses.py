## Author: Chris Hoerle
## Date: 08/20/2021

'''
	Given a string s containing just the characters '(', ')', '{', '}', 
	'[' and ']', determine if the input string is valid.

	An input string is valid if:
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
 
	Examples:
	Input: s = "()"
	Output: true

	Input: s = "()[]{}"
	Output: true

	Input: s = "(]"
	Output: false

	Input: s = "([)]"
	Output: false

	Input: s = "{[]}"
	Output: true
 
	Constraints:
	1 <= s.length <= 104
	s consists of parentheses only '()[]{}'.
'''

class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 != 0:
            return False
        
        stack = []
        
        for i in range(0, len(s)):
            if s[i] == '(' or s[i] == '{' or s[i] == '[':
                stack.append(s[i])
            elif s[i] == ')' and not stack == [] and stack[-1] == '(':
                stack.pop()
            elif s[i] == '}' and not stack == [] and stack[-1] == '{':
                stack.pop()
            elif s[i] == ']' and not stack == [] and stack[-1] == '[':
                stack.pop()
            else:
                return False
        
        return stack == []