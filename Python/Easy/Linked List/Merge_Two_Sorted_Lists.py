## Author: Chris Hoerle
## Date: 08/11/2021

'''
	Merge two sorted linked lists and return it as a sorted list. 
	The list should be made by splicing together the nodes of the 
	first two lists.

 	Examples:
	Input: l1 = [1,2,4], l2 = [1,3,4]
	Output: [1,1,2,3,4,4]

	Input: l1 = [], l2 = []
	Output: []

	Input: l1 = [], l2 = [0]
	Output: [0]
 
	Constraints:
	The number of nodes in both lists is in the range [0, 50].
	-100 <= Node.val <= 100
	Both l1 and l2 are sorted in non-decreasing order.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        temp = ListNode(0)
        result = temp
        
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                temp.next = l1
                l1 = l1.next
            else:
                temp.next = l2
                l2 = l2.next
            temp = temp.next
        
        if l1 is not None:
            temp.next = l1
        
        else:
            temp.next = l2
        
        return result.next