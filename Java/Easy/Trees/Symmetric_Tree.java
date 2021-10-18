// Author: Chris Hoerle
// Date: 08/12/2021

/*
	Given the root of a binary tree, check whether it is a mirror 
	of itself (i.e., symmetric around its center).

 	Examples:
	Input: root = [1,2,2,3,4,4,3]
	Output: true

	Input: root = [1,2,2,null,3,null,3]
	Output: false
 
	Constraints:
	The number of nodes in the tree is in the range [1, 1000].
	-100 <= Node.val <= 100
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

// Time Complexity: O(n) because need to traverse through entire tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;   
        }  
        
        return symmetric(root.left, root.right);
    }
    
    public boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left == right) {
                return true;
            }
            return false;
        }
        
        if (left.val != right.val) {
            return false;
        }
        
        return symmetric(left.left, right.right) && symmetric(left.right, right.left); 
    }
}