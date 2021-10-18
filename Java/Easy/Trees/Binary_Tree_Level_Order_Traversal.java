// Author: Chris Hoerle
// Date: 08/20/2021

/*
	Given the root of a binary tree, return the level order traversal 
	of its nodes' values. (i.e., from left to right, level by level).

 	Examples:
	Input: root = [3,9,20,null,null,15,7]
	Output: [[3],[9,20],[15,7]]

	Input: root = [1]
	Output: [[1]]

	Input: root = []
	Output: []
 
	Constraints:
	The number of nodes in the tree is in the range [0, 2000].
	-1000 <= Node.val <= 1000
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

// Implementation: Create a result list that stores each level of nodes (each level is a list)
// While traversing through each level of the tree, left to right, store the nodes in queue.
// When going to the next level, remove the previous level's nodes from the queue and store 
// their values in its level list. Check if these nodes have children. If they do, store them 
// in the queue and repeat the process until the queue is empty or every child is null. For 
// each iteration, add each level of nodes to the result.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}