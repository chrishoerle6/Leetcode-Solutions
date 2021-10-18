# Author: Chris Hoerle
# Date: 08/04/2021

'''
	Given a non-empty array of decimal digits representing a non-negative 
	integer, increment one to the integer. The digits are stored such that 
	the most significant digit is at the head of the list, and each element 
	in the array contains a single digit. You may assume the integer does 
	not contain any leading zero, except the number 0 itself.

 	Examples:
	Input: digits = [1,2,3]
	Output: [1,2,4]
	Explanation: The array represents the integer 123.

	Input: digits = [4,3,2,1]
	Output: [4,3,2,2]
	Explanation: The array represents the integer 4321.

	Input: digits = [0]
	Output: [1]
 
 	Constraints:
	1 <= digits.length <= 100
	0 <= digits[i] <= 9
'''

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in reversed(range(len(digits))):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            digits[i] = 0
        digits.append(0)
        digits[0] = 1
        return digits