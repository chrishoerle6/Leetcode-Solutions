## Author: Chris Hoerle
## Date: 08/12/2021

'''
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
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        return self.symmetric(root.left, root.right)
    
    
    def symmetric(self, left, right):
        if left is None or right is None:
            if left == right:
                return True
            return False
        
        if left.val != right.val:
            return False
        
        return self.symmetric(left.left, right.right) and self.symmetric(left.right, right.left)