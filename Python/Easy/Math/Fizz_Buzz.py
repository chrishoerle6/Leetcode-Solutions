## Author: Chris Hoerle
## Date: 08/20/2021

'''
	Given an integer n, return a string array answer (1-indexed) where:
	answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
	answer[i] == "Fizz" if i is divisible by 3.
	answer[i] == "Buzz" if i is divisible by 5.
	answer[i] == i if non of the above conditions are true.
 
	Examples:
	Input: n = 3
	Output: ["1","2","Fizz"]

	Input: n = 5
	Output: ["1","2","Fizz","4","Buzz"]

	Input: n = 15
	Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 
	Constraints:
	1 <= n <= 104
'''

class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        result = []
        
        for i in range(1, n + 1):
            if i % 3 is 0 and i % 5 is 0:
                result.append('FizzBuzz')
            elif i % 3 is 0:
                result.append('Fizz')
            elif i % 5 is 0:
                result.append('Buzz')
            else:
                result.append(str(i))
        
        return result