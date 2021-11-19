// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an integer n, return the number of trailing zeroes in n!.
	Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

	Examples:
	Input: n = 3
	Output: 0
	Explanation: 3! = 6, no trailing zero.

	Input: n = 5
	Output: 1
	Explanation: 5! = 120, one trailing zero.

	Input: n = 0
	Output: 0
	 
	Constraints:
	0 <= n <= 104
	Follow up: Could you write a solution that works in logarithmic 
	time complexity?	
*/

class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        
        while (n > 0) {
            n /= 5;
            result += n;
        }
        
        return result;
    }
}