// Author: Chris Hoerle
// Date: 11/19/2021

/*
	You are given a perfect binary tree where all leaves are on the same level, 
	and every parent has two children. The binary tree has the following definition:

	struct Node {
	  int val;
	  Node *left;
	  Node *right;
	  Node *next;
	}

	Populate each next pointer to point to its next right node. If there is no next 
	right node, the next pointer should be set to NULL. Initially, all next pointers 
	are set to NULL.

	Examples:
	Input: root = [1,2,3,4,5,6,7]
	Output: [1,#,2,3,#,4,5,6,7,#]
	Explanation: Given the above perfect binary tree (Figure A), your function should 
	populate each next pointer to point to its next right node, just like in Figure B. 
	The serialized output is in level order as connected by the next pointers, with '#' 
	signifying the end of each level.

	Input: root = []
	Output: []
	 
	Constraints:
	The number of nodes in the tree is in the range [0, 212 - 1].
	-1000 <= Node.val <= 1000
	 
	Follow-up:
	You may only use constant extra space.
	The recursive approach is fine. You may assume implicit stack space does not count 
	as extra space for this problem.	
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// Logic: Use level order traversal and a queue
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        queue.add(null);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // If we are at the end of the tree
            if (current == null && queue.isEmpty()) {
                return root;
            }
            // If we are at the end of a level
            else if (current == null) {
                // Add a null for the next level
                queue.add(null);
                continue;
            }
            // If we are at a node 
            else {
                // Set the nodes next pointer to the node to the right of it
                current.next = queue.peek();
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }
}