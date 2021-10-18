## Author: Chris Hoerle
## Date: 08/20/2021

'''
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
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        
        if root is None:
            return result
        
        queue = []
        queue.append(root)
        
        while len(queue) != 0:
            level_size = len(queue)
            level = []
            
            for i in range(0, level_size):
                node = queue[0]
                queue.remove(node)
                level.append(node.val)
                
                if node.left is not None:
                    queue.append(node.left)
                    
                if node.right is not None:
                    queue.append(node.right)
            
            result.append(level)
        
        return result 