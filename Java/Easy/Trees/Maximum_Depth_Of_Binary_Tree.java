// Author: Chris Hoerle
// Date: 08/12/2021

/*
	Given the root of a binary tree, return its maximum depth.
	A binary tree's maximum depth is the number of nodes along the 
	longest path from the root node down to the farthest leaf node.

 	Examples:
	Input: root = [3,9,20,null,null,15,7]
	Output: 3

	Input: root = [1,null,2]
	Output: 2

	Input: root = []
	Output: 0

	Input: root = [0]
	Output: 1
 
 	Constraints:
	The number of nodes in the tree is in the range [0, 104].
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
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Recursion
        // Movie Theatre Row Analogy: Don't know what row you're in?
        // Ask the row in front of you what row they're in and they keep asking the
        // same question to the row in front of them until getting to the last row.
        // And then the infromation will be passed back up to you
        // Time Complexity: O(n) because traversing the entire tree
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}