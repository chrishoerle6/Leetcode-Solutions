// Author: Chris Hoerle
// Date: 08/11/2021

/*
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
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Find middle of the linked list. Two pointers: slow and fast
// Move slow by 1 and fast by 2 while fast.next (odd list) 
// or fast.next.next (even list) != null. slow = middle 
// Reverse second half of list starting at slow.next
// Move slow to slow.next or beginning of reve rsed half
// Loop through both halves and compare values while slow != null
// If values in halves are equal then palindrome.
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        slow = slow.next;
        
        ListNode dummy = head;
        while (slow != null) {
            if (dummy.val != slow.val) {
                return false;
            } 
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode temp = null;
        ListNode reverse = null;
        
        while (head != null) {
            temp = head.next;
            head.next = reverse;
            reverse = head;
            head = temp;
        }
        return reverse;
    }
}