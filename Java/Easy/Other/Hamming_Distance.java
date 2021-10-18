// Author: Chris Hoerle
// Date: 08/20/2021

/*
	The Hamming distance between two integers is the number of 
	positions at which the corresponding bits are different.
	Given two integers x and y, return the Hamming distance 
	between them.

 	Examples:
	Input: x = 1, y = 4
	Output: 2
	Explanation:
	1   (0 0 0 1)
	4   (0 1 0 0)
	       ↑   ↑
	The above arrows point to positions where the corresponding 
	bits are different.

	Input: x = 3, y = 1
	Output: 1
 
	Constraints:
	0 <= x, y <= 231 - 1
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int n = x ^ y;
        
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
        // Can also just return Integer.bitCount(x ^ y)
    }
}