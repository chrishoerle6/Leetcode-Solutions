// Author: Chris Hoerle
// Date: 08/20/2021

/*
	Given an integer array nums, find the contiguous subarray (containing 
	at least one number) which has the largest sum and return its sum. A 
	subarray is a contiguous part of an array.

 	Examples:
	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.

	Input: nums = [1]
	Output: 1

	Input: nums = [5,4,-1,7,8]
	Output: 23
 
	Constraints:
	1 <= nums.length <= 3 * 104
	-105 <= nums[i] <= 105	
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }