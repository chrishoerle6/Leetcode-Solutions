# Author: Chris Hoerle
# Date: 08/04/2021

'''
	Given a non-empty array of integers nums, every element appears twice 
	except for one. Find that single one. You must implement a solution with 
	a linear runtime complexity and use only constant extra space.

 	Examples:
	Input: nums = [2,2,1]
	Output: 1

	Input: nums = [4,1,2,1,2]
	Output: 4

	Input: nums = [1]
	Output: 1
 	
	Constraints:
	1 <= nums.length <= 3 * 104
	-3 * 104 <= nums[i] <= 3 * 104
	Each element in the array appears twice except for one element which 
	appears only once.	
'''

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        seen = []
        
        for i in range(len(nums)):
            if nums[i] in seen:
                seen.remove(nums[i])
            else:
                seen.append(nums[i])
        
        return seen[0]