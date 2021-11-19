// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an array of integers nums sorted in non-decreasing order, 
	find the starting and ending position of a given target value.
	If target is not found in the array, return [-1, -1].
	You must write an algorithm with O(log n) runtime complexity.

	Examplea:
	Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]

	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]

	Input: nums = [], target = 0
	Output: [-1,-1]

	Constraints:
	0 <= nums.length <= 105
	-109 <= nums[i] <= 109
	nums is a non-decreasing array.
	-109 <= target <= 109			
*/

class Solution {
    // Note: Whenever you see O(log n) think binary search
    // Do a binary search to find the starting index
    // Do a binary search to find the ending index
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }
    
    public int findStartingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] >= target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            
            if (nums[mid] == target) {
                index = mid;
            }  
        }
        
        return index;
    }
    
    public int findEndingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
            
            if (nums[mid] == target) {
                index = mid;
            }
        }
        
        return index;
    }
}