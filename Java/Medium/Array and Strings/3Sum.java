// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an integer array nums, return all the triplets [nums[i], 
	nums[j], nums[k]] such that i != j, i != k, and j != k, and 
	nums[i] + nums[j] + nums[k] == 0.

	Notice that the solution set must not contain duplicate triplets.

 	Examples:
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]

	Input: nums = []
	Output: []

	Input: nums = [0]
	Output: []

	Constraints:
	0 <= nums.length <= 3000
	-105 <= nums[i] <= 105
*/

// Time Complexity: O(nlogn) "sorting" + O(n^2) "nested loop" = O(n^2)
// Space Complexity: O(n) or O(1). Depends on implementation of sorting
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right -= 1;
                }
                else if (nums[i] + nums[left] + nums[right] < 0) {
                    left += 1;
                }
                else {
                    List<Integer> triplet = new LinkedList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);
                    
                    left += 1;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left += 1;
                    }
                }
            }
        }
        return result;
    }
}