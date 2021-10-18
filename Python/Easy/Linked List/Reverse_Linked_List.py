## Author: Chris Hoerle
## Date: 08/11/2021

'''
	Given the head of a singly linked list, reverse the list, 
	and return the reversed list.

 	Examples:
	Input: head = [1,2,3,4,5]
	Output: [5,4,3,2,1]

	Input: head = [1,2]
	Output: [2,1]

	Input: head = []
	Output: []
 
	Constraints:
	The number of nodes in the list is the range [0, 5000].
	-5000 <= Node.val <= 5000
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        reverse = ListNode()
        reverse = None
        
        while head is not None:
            temp = ListNode()
            temp = head.next
            head.next = reverse
            reverse = head
            head = temp
        
        return reverse