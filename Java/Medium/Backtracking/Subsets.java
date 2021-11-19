// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an integer array nums of unique elements, return all 
	possible subsets (the power set). The solution set must not 
	contain duplicate subsets. Return the solution in any order.

	Examplea:
	Input: nums = [1,2,3]
	Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

	Input: nums = [0]
	Output: [[],[0]]
	 
	Constraints:
	1 <= nums.length <= 10
	-10 <= nums[i] <= 10
	All the numbers of nums are unique.  
*/

class Solution {
    // Time Complexity: O(2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        backtrack(result, subset, nums, 0);
        
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int index) {
        result.add(new ArrayList<>(subset));
        
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        } 
    }
}