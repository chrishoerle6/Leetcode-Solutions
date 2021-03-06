// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given the root of a binary search tree, and an integer k, return 
	the kth smallest value (1-indexed) of all the values of the nodes 
	in the tree.

	Examples:
	Input: root = [3,1,4,null,2], k = 1
	Output: 1

	Input: root = [5,3,6,2,4,null,null,1], k = 3
	Output: 3
	 
	Constraints:
	The number of nodes in the tree is n.
	1 <= k <= n <= 104
	0 <= Node.val <= 104
	 
	Follow up: If the BST is modified often (i.e., we can do insert and 
	delete operations) and you need to find the kth smallest frequently, 
	how would you optimize?	
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        
        return result.get(k - 1);
    }
}