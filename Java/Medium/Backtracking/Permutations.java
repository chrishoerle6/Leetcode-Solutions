// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an array nums of distinct integers, return all the possible 
	permutations. You can return the answer in any order.

	Examplea:
	Input: nums = [1,2,3]
	Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

	Input: nums = [0,1]
	Output: [[0,1],[1,0]]

	Input: nums = [1]
	Output: [[1]]
	 
	Constraints:
	1 <= nums.length <= 6
	-10 <= nums[i] <= 10
	All the integers of nums are unique.   
*/

class Solution {
    // Time Complexity: O(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(result, permutation, nums, used);
        
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums, boolean[] used) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            used[i] = true;
            permutation.add(nums[i]);
            backtrack(result, permutation, nums, used);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }
}