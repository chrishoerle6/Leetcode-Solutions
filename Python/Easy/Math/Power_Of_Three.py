## Author: Chris Hoerle
## Date: 08/20/2021

'''
	Given an integer n, return true if it is a power of three. 
	Otherwise, return false. An integer n is a power of three, 
	if there exists an integer x such that n == 3x.

 	Examples:
	Input: n = 27
	Output: true

	Input: n = 0
	Output: false

	Input: n = 9
	Output: true

	Input: n = 45
	Output: false
 
	Constraints:
	-231 <= n <= 231 - 1
'''

class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0:
            return False
        
        while n > 1:
            if n % 3 != 0:
                return False
            
            n = n / 3
        
        return True