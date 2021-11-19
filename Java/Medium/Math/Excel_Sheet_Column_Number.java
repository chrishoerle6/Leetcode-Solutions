// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given a string columnTitle that represents the column title as appear in 
	an Excel sheet, return its corresponding column number.
	For example:
	A -> 1
	B -> 2
	C -> 3
	...
	Z -> 26
	AA -> 27
	AB -> 28 
	...
	 
	Examplea:
	Input: columnTitle = "A"
	Output: 1

	Input: columnTitle = "AB"
	Output: 28

	Input: columnTitle = "ZY"
	Output: 701

	Input: columnTitle = "FXSHRXW"
	Output: 2147483647
	 
	Constraints:
	1 <= columnTitle.length <= 7
	columnTitle consists only of uppercase English letters.
	columnTitle is in the range ["A", "FXSHRXW"].		
*/

class Solution {
    // String = "LEET"
    // L = 12
    // E = (12 * 26) + 5 = 317
    // E = (317 * 26) + 5 = 8247
    // T = (8247 * 26) + 20 = 214442
    public int titleToNumber(String columnTitle) {
        HashMap<Character, Integer> alphabet = new HashMap<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            int value = (int) c % 64;
            alphabet.put(c, value);   
        }
        
        char[] characters = columnTitle.toCharArray();
        int result = alphabet.get(characters[0]);
        
        for (int i = 1; i < characters.length; i++) {
            result = (result * 26) + alphabet.get(characters[i]);    
        }
        
        return result;
    }
}