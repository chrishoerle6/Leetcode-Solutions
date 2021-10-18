// Author: Chris Hoerle
// Date: 08/04/2021

/*
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
*/

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);   
            }
            else {
                set.add(nums[i]);
            }
        }
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result = nums[i]; 
            }
        }
        return result;
    }
}
