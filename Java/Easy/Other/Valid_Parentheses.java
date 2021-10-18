// Author: Chris Hoerle
// Date: 08/20/2021

/*
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
*/

class Solution {
    public boolean isValid(String s) {
        // Stack problem
        
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack();
        
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        // If the stack is empty then the string is valid and we return true 
        return stack.isEmpty();
    }
}