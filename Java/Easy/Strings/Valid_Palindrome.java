// Author: Chris Hoerle
// Date: 08/09/2021

/*
	Given a string s, determine if it is a palindrome, considering 
	only alphanumeric characters and ignoring cases.

 	Examples:
	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.

	Input: s = "race a car"
	Output: false
	Explanation: "raceacar" is not a palindrome.
 

	Constraints:
	1 <= s.length <= 2 * 105
	s consists only of printable ASCII characters.	
*/

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        String reversed = s;
        char[] arrayS = s.toCharArray();
        char[] arrayReversed = reversed.toCharArray();
        int start = 0;
        int end = arrayReversed.length - 1;
        
        while (start <= end) {
            char temp = arrayReversed[start];
            arrayReversed[start] = arrayReversed[end];
            arrayReversed[end] = temp;
            start++;
            end--;
        }
        
        for (int i = 0; i < arrayReversed.length; i++) {
            if (arrayReversed[i] != arrayS[i]) {
                return false;
            }
        }
        return true;
    }
}