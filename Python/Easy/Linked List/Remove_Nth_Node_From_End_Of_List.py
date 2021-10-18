## Author: Chris Hoerle
## Date: 08/11/2021

'''
	Given the head of a linked list, remove the nth node from the end 
	of the list and return its head.

 	Examples:
	Input: head = [1,2,3,4,5], n = 2
	Output: [1,2,3,5]

	Input: head = [1], n = 1
	Output: []

	Input: head = [1,2], n = 1
	Output: [1]
 
	Constraints:
	The number of nodes in the list is sz.
	1 <= sz <= 30
	0 <= Node.val <= 100
	1 <= n <= sz
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        start = ListNode()
        start.next = head
        fast = start
        slow = start
        
        for i in range(0, n):
            fast = fast.next
        
        while fast.next is not None:
            fast = fast.next
            slow = slow.next
        
        slow.next = slow.next.next
        return start.next