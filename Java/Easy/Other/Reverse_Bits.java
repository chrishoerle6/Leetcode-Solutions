// Author: Chris Hoerle
// Date: 08/20/2021

/*
	Reverse bits of a given 32 bits unsigned integer.

	Note:
	Note that in some languages such as Java, there is no unsigned 
	integer type. In this case, both input and output will be given as 
	a signed integer type. They should not affect your implementation, 
	as the integer's internal binary representation is the same, whether 
	it is signed or unsigned. In Java, the compiler represents the signed 
	integers using 2's complement notation. Therefore, in Example 2 above, 
	the input represents the signed integer -3 and the output represents 
	the signed integer -1073741825.

	Examples:
	Input: n = 00000010100101000001111010011100
	Output:    964176192 (00111001011110000010100101000000)
	Explanation: The input binary string 00000010100101000001111010011100 
	represents the unsigned integer 43261596, so return 964176192 which 
	its binary representation is 00111001011110000010100101000000.

	Input: n = 11111111111111111111111111111101
	Output:   3221225471 (10111111111111111111111111111111)
	Explanation: The input binary string 11111111111111111111111111111101 
	represents the unsigned integer 4294967293, so return 3221225471 which 
	its binary representation is 10111111111111111111111111111111.
 
	Constraints:
	The input must be a binary string of length 32
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        
        // Approach: on each itertion, shift reverse to the left by 1 bit.
        // & the first bit of n with 1 and OR this with reverse, adding it to its first bit
        // Then shift n to the right by 1 bit   
        for (int i = 0; i < 32; i++) {
            reverse = reverse << 1;
            reverse = reverse | (n & 1);
            n = n >> 1; 
        }
        return reverse;
    }
}