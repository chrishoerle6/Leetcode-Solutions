## Author: Chris Hoerle
## Date: 08/20/2021

'''
	Count the number of prime numbers less than a non-negative number, n.

 	Examples:
	Input: n = 10
	Output: 4
	Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

	Input: n = 0
	Output: 0

	Input: n = 1
	Output: 0
 
	Constraints:
	0 <= n <= 5 * 106
'''

class Solution:
    def countPrimes(self, n: int) -> int:
        if n == 0 or n == 1:
            return 0
        
        primes = [1]*n
        primes[0] = 0
        primes[1] = 0
        
        i = 2
        while i < n:
            temp = i
            if primes[i]:
                temp += i
                while temp < n:
                    primes[temp] = 0
                    temp += i
            i += 1
        
        return sum(primes) 