## Author: Chris Hoerle
## Date: 08/12/2021

'''
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
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        return max(left, right) + 1