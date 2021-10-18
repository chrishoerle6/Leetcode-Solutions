// Author: Chris Hoerle
// Date: 08/11/2021

/*
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create dummy node
        ListNode start = new ListNode();
        start.next = head;
        // Create two pointers, fast and slow
        ListNode fast = start;
        ListNode slow = start;
        
        // Move fast to the value of n
        for (int i = 1; i <= n; i++) {
            fast = fast.next;   
        }
        
        // Move both pointers until fast is the last node or before null
        // Slow should be the node before the one we're deleting 
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Delete the node
        slow.next = slow.next.next;
        return start.next;
    }
}