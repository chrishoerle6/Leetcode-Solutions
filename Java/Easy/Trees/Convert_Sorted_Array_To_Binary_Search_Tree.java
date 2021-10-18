// Author: Chris Hoerle
// Date: 08/20/2021

/*
	Given an integer array nums where the elements are sorted 
	in ascending order, convert it to a height-balanced binary 
	search tree. A height-balanced binary tree is a binary tree 
	in which the depth of the two subtrees of every node never 
	differs by more than one.

 	Examples:
	Input: nums = [-10,-3,0,5,9]
	Output: [0,-3,9,-10,null,5]
	Explanation: [0,-10,5,null,-3,null,9] is also accepted:

	Input: nums = [1,3]
	Output: [3,1]
	Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 
	Constraints:
	1 <= nums.length <= 104
	-104 <= nums[i] <= 104
	nums is sorted in a strictly increasing order.	
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Note: Think binary search when we see sorted array
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructTreeFromArray(int nums[], int left, int right) {
        if (left > right) {
            return null;
        }
        
        int midpoint = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[midpoint]);
        
        node.left = constructTreeFromArray(nums, left, midpoint - 1);
        node.right = constructTreeFromArray(nums, midpoint + 1, right);
        
        return node;
    }
}