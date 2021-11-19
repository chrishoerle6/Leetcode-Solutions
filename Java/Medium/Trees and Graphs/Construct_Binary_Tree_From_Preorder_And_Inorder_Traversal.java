// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given two integer arrays preorder and inorder where preorder is the 
	preorder traversal of a binary tree and inorder is the inorder traversal 
	of the same tree, construct and return the binary tree.

	Examples:
	Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	Output: [3,9,20,null,null,15,7]

	Input: preorder = [-1], inorder = [-1]
	Output: [-1]
	 
	Constraints:
	1 <= preorder.length <= 3000
	inorder.length == preorder.length
	-3000 <= preorder[i], inorder[i] <= 3000
	preorder and inorder consist of unique values.
	Each value of inorder also appears in preorder.
	preorder is guaranteed to be the preorder traversal of the tree.
	inorder is guaranteed to be the inorder traversal of the tree.
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

// Logic To Construct Tree: The first element of the preorder array
// is always the root. When finding this value in the inorder array,
// every element to the left of this is in the left subtree and every
// element to the right of this is in the right subtree. Repeat this
// logic recursively until we traverse through the arrays. 
class Solution {
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode build(int[] preOrder, int[] inOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(preOrder[preIndex++]);
        
        if (root == null) {
            return null;
        }
        if (start == end) {
            return root;
        }
        
        int index = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (root.val == inOrder[i]) {
                index = i;
            }
        }
        
        root.left = build(preOrder, inOrder, start, index - 1);
        root.right = build(preOrder, inOrder, index + 1, end);
        
        return root;
    }
}