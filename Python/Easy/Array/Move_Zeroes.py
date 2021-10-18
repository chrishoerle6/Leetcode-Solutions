# Author: Chris Hoerle
# Date: 08/04/2021

'''
	Given an integer array nums, move all 0's to the end of it while 
	maintaining the relative order of the non-zero elements. Note that 
	you must do this in-place without making a copy of the array.

 	Examples:
	Input: nums = [0,1,0,3,12]
	Output: [1,3,12,0,0]

	Input: nums = [0]
	Output: [0]
 
	Constraints:
	1 <= nums.length <= 104
	-231 <= nums[i] <= 231 - 1	
'''

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[index] = nums[i]
                index += 1
        for i in reversed(range(index, len(nums))):
            nums[i] = 0