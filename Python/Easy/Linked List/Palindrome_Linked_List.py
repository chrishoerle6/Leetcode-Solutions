## Author: Chris Hoerle
## Date: 08/11/2021

'''
	Given the head of a singly linked list, return true if it 
	is a palindrome.

 	Examples:
	Input: head = [1,2,2,1]
	Output: true

	Input: head = [1,2]
	Output: false
 
	Constraints:
	The number of nodes in the list is in the range [1, 105].
	0 <= Node.val <= 9
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return True
        
        fast = head
        slow = head
        
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        slow.next = self.reverse(slow.next)
        slow = slow.next
        
        while slow is not None:
            if head.val != slow.val:
                return False
            head = head.next
            slow = slow.next
        
        return True

    
    def reverse(self, head):
        temp = None
        reverse = None
        
        while head is not None:
                temp = head.next
                head.next = reverse
                reverse = head
                head = temp
        
        return reverse
    