// Author: Chris Hoerle
// Date: 08/09/2021

/*
	Write a function that reverses a string. The input string is given 
	as an array of characters s.

 	Examples:
	Input: s = ["h","e","l","l","o"]
	Output: ["o","l","l","e","h"]

	Input: s = ["H","a","n","n","a","h"]
	Output: ["h","a","n","n","a","H"]
 
	Constraints:
	1 <= s.length <= 105
	s[i] is a printable ascii character.	
*/

class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}