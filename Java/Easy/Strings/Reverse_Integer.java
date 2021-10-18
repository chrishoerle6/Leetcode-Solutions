// Author: Chris Hoerle
// Date: 08/09/2021

/*
	Given a signed 32-bit integer x, return x with its digits reversed. 
	If reversing x causes the value to go outside the signed 32-bit integer 
	range [-231, 231 - 1], then return 0. Assume the environment does not 
	allow you to store 64-bit integers (signed or unsigned).

 	Examples:
	Input: x = 123
	Output: 321

	Input: x = -123
	Output: -321

	Input: x = 120
	Output: 21

	Input: x = 0
	Output: 0
 
	Constraints:
	-231 <= x <= 231 - 1	
*/

class Solution {
    public int reverse(int x) {
        boolean negative = false;
        
        if (x < 0) {
            negative = true;
            x *= -1;
        }
        
        long reversed = 0;
        
        while (x > 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }
        
        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }
        
        if (negative == true) {
            reversed *= -1;
        }
        return (int)reversed;
    }
}