# Author: Chris Hoerle
# Date: 08/09/2021

'''
	Implement the myAtoi(string s) function, which converts a string to a 
	32-bit signed integer (similar to C/C++'s atoi function).The algorithm 
	for myAtoi(string s) is as follows:

	Read in and ignore any leading whitespace. Check if the next character 
	(if not already at the end of the string) is '-' or '+'. Read this character 
	in if it is either. This determines if the final result is negative or 
	positive respectively. Assume the result is positive if neither is present.
	Read in next the characters until the next non-digit charcter or the end of 
	the input is reached. The rest of the string is ignored. Convert these digits 
	into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, 
	then the integer is 0. Change the sign as necessary (from step 2). If the 
	integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp 
	the integer so that it remains in the range. Specifically, integers less than 
	-231 should be clamped to -231, and integers greater than 231 - 1 should be 
	clamped to 231 - 1. Return the integer as the final result.
	
	Note: Only the space character ' ' is considered a whitespace character. Do not 
	ignore any characters other than the leading whitespace or the rest of the string 
	after the digits.
 
	Examples:
	Input: s = "42"
	Output: 42
	Explanation: The underlined characters are what is read in, the caret is the 
	current reader position.
	Step 1: "42" (no characters read because there is no leading whitespace)
	Step 2: "42" (no characters read because there is neither a '-' nor '+')
	Step 3: "42" ("42" is read in)
	The parsed integer is 42.
	Since 42 is in the range [-231, 231 - 1], the final result is 42.

	Input: s = "   -42"
	Output: -42
	Explanation:
	Step 1: "   -42" (leading whitespace is read and ignored)
	Step 2: "   -42" ('-' is read, so the result should be negative)
	Step 3: "   -42" ("42" is read in)
	The parsed integer is -42.
	Since -42 is in the range [-231, 231 - 1], the final result is -42.

	Input: s = "4193 with words"
	Output: 4193
	Explanation:
	Step 1: "4193 with words" (no characters read because there is no leading whitespace)
	Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
	Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
	The parsed integer is 4193.
	Since 4193 is in the range [-231, 231 - 1], the final result is 4193.

	Input: s = "words and 987"
	Output: 0
	Explanation:
	Step 1: "words and 987" (no characters read because there is no leading whitespace)
	Step 2: "words and 987" (no characters read because there is neither a '-' nor '+')
	Step 3: "words and 987" (reading stops immediately because there is a non-digit 'w')
	The parsed integer is 0 because no digits were read.
	Since 0 is in the range [-231, 231 - 1], the final result is 0.

	Input: s = "-91283472332"
	Output: -2147483648
	Explanation:
	Step 1: "-91283472332" (no characters read because there is no leading whitespace)
	Step 2: "-91283472332" ('-' is read, so the result should be negative)
	Step 3: "-91283472332" ("91283472332" is read in)
	The parsed integer is -91283472332.
	Since -91283472332 is less than the lower bound of the range [-231, 231 - 1], 
	the final result is clamped to -231 = -2147483648.
 
	Constraints:
	0 <= s.length <= 200
	s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.	
'''

class Solution:
    def myAtoi(self, s: str) -> int:
        result = 0
        i = 0
        isNegative = False
        MAX_INT = 2 ** 31 - 1
        MIN_INT = -2 ** 31
        
        # remove white spaces
        while i < len(s) and s[i] == ' ':
            i += 1
        
        # remove +/-
        if i < len(s) and s[i] == '-':
            isNegative = True
            i += 1
        elif i < len(s) and s[i] == '+':
            i += 1
        
        #check number 0-9
        checker = set('0123456789')
        while i < len(s) and s[i] in checker:
            result = result * 10 + int(s[i])
            i += 1
        
        if isNegative:
            result = -result
        
        if result > MAX_INT:
            return MAX_INT
        elif result < MIN_INT:
            return MIN_INT
        
        return result