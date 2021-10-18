# Author: Chris Hoerle
# Date: 07/07/2021

''' 
    Given an array integers nums and an integer target, return indices
    of the two numbers such that they add up to target. You may assume
    that each input would have exactly one solution, and you may not use 
    the same element twice. You can return the answer in any order.

    Examples:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1] becaue nums[0] + nums[1] == 9 

    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
'''

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    result = [i, j]
                    return result
        result = []
        return result