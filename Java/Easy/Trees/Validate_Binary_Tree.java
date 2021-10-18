// Author: Chris Hoerle
// Date: 08/12/2021

/*
	Given the root of a binary tree, determine if it is a valid 
	binary search tree (BST).
	A valid BST is defined as follows:
	The left subtree of a node contains only nodes with keys less 
	than the node's key. The right subtree of a node contains only 
	nodes with keys greater than the node's key. Both the left and 
	right subtrees must also be binary search trees.
 
 	Examples:
	Input: root = [2,1,3]
	Output: true

	Input: root = [5,1,4,null,null,3,6]
	Output: false
	Explanation: The root node's value is 5 but its right child's 
	value is 4.
 
 	Constraints:
	The number of nodes in the tree is in the range [1, 104].
	-231 <= Node.val <= 231 - 1
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        // null and null mean +infinity and -infinity
        return validate(root, null, null);
    }
    
    // Every number has a valid range
    // For node on left tree: (min of parent node, value of parent node)
    // For node on right tree: (value of parent node, max of parent node)
    public boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        
        else if (min != null && root.val <= min) {
            return false;
        }
       
        else if (max != null && root.val >= max) {
            return false;
        }
        
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}