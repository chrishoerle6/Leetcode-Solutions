// Author: Chris Hoerle
// Date: 08/11/2021

/*
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
    public ListNode reverseList(ListNode head) {
        // Create a dummy node equal to node
        ListNode reverse = null;
        
        // Iterate while head is not null
        // 1. Set a temp to the head's next
        // 2. Point the heads next to the dummy node
        // 3. Set the dummy node to the head
        // 4. Set the head to temp
        while (head != null) {
            ListNode temp = head.next;
            head.next = reverse;
            reverse = head;
            head = temp;
        }
        return reverse;
    }
}