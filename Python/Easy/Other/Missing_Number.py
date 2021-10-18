## Author: Chris Hoerle
## Date: 08/20/2021

'''
	Given an array nums containing n distinct numbers in the range 
	[0, n], return the only number in the range that is missing from 
	the array.

	Examples:
	Input: nums = [3,0,1]
	Output: 2
	Explanation: n = 3 since there are 3 numbers, so all numbers are 
	in the range [0,3]. 2 is the missing number in the range since it 
	does not appear in nums.

	Input: nums = [0,1]
	Output: 2
	Explanation: n = 2 since there are 2 numbers, so all numbers are 
	in the range [0,2]. 2 is the missing number in the range since it 
	does not appear in nums.

	Input: nums = [9,6,4,2,3,5,7,0,1]
	Output: 8
	Explanation: n = 9 since there are 9 numbers, so all numbers are 
	in the range [0,9]. 8 is the missing number in the range since it 
	does not appear in nums.

	Input: nums = [0]
	Output: 1
	Explanation: n = 1 since there is 1 number, so all numbers are in 
	the range [0,1]. 1 is the missing number in the range since it does 
	not appear in nums.
 
	Constraints:
	n == nums.length
	1 <= n <= 104
	0 <= nums[i] <= n
	All the numbers of nums are unique.
'''

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        unique = []
        
        for i in range(0, len(nums)):
            unique.append(nums[i])
            
        for i in range(0, len(nums) + 1):
            if i not in unique:
                return i
        
        return -1