// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given the root of a binary tree, return the zigzag level order traversal of 
	its nodes' values. (i.e., from left to right, then right to left for the next 
	level and alternate between).

	Examples:
	Input: root = [3,9,20,null,null,15,7]
	Output: [[3],[20,9],[15,7]]

	Input: root = [1]
	Output: [[1]]

	Input: root = []
	Output: []
	 
	Constraints:
	The number of nodes in the tree is in the range [0, 2000].
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean reverse = false;
        
        while (!stack.isEmpty()) {
            int levelSize = stack.size();
            List<Integer> level = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = stack.pop();
                level.add(node.val);
                
                if (!reverse) {
                    if (node.left != null) {
                        tempStack.push(node.left);
                    }
                    if (node.right != null) {
                        tempStack.push(node.right);
                    }
                }
                else {
                    if (node.right != null) {
                        tempStack.push(node.right);
                    }
                    if (node.left != null) {
                        tempStack.push(node.left);
                    }    
                }
            }
            
            result.add(level);
            reverse = !reverse;
            stack = tempStack;
        }
        
        return result;
    }
}