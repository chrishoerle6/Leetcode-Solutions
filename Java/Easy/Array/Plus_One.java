// Author: Chris Hoerle
// Date: 07/20/2021

/*
	Given a non-empty array of decimal digits representing a non-negative 
	integer, increment one to the integer. The digits are stored such that 
	the most significant digit is at the head of the list, and each element 
	in the array contains a single digit. You may assume the integer does 
	not contain any leading zero, except the number 0 itself.

 	Examples:
	Input: digits = [1,2,3]
	Output: [1,2,4]
	Explanation: The array represents the integer 123.

	Input: digits = [4,3,2,1]
	Output: [4,3,2,2]
	Explanation: The array represents the integer 4321.

	Input: digits = [0]
	Output: [1]
 
 	Constraints:
	1 <= digits.length <= 100
	0 <= digits[i] <= 9
*/

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] nines = new int[digits.length + 1];
        nines[0] = 1;
        return nines;
    }
}