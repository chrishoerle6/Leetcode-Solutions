// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an integer array nums, return true if there exists a triple 
	of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. 
	If no such indices exists, return false.

	Examples:
	Input: nums = [1,2,3,4,5]
	Output: true
	Explanation: Any triplet where i < j < k is valid.

	Input: nums = [5,4,3,2,1]
	Output: false
	Explanation: No triplet exists.

	Input: nums = [2,1,5,0,4,6]
	Output: true
	Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < 
	nums[4] == 4 < nums[5] == 6.
	 
	Constraints:
	1 <= nums.length <= 5 * 105
	-231 <= nums[i] <= 231 - 1	
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        
        for (int in = 0; in < nums.length; in++) {
            if (nums[in] <= i) {
                i = nums[in];
            }
            else if (nums[in] <= j) {
                j = nums[in];
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}