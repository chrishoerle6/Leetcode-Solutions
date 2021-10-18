// Author: Chris Hoerle
// Date: 08/20/2021

/*
	Count the number of prime numbers less than a non-negative number, n.

 	Examples:
	Input: n = 10
	Output: 4
	Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

	Input: n = 0
	Output: 0

	Input: n = 1
	Output: 0
 
	Constraints:
	0 <= n <= 5 * 106
*/

class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n]; // initializes all to false
        int count = 0;
        
        // i * i and j * i because no primes greater than the current number and its square
        for (int i = 2; i * i < primes.length; i++) {
            // Check if false
            if (!primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = true;
                }    
            }
        }
        
        for (int i = 2; i < n; i++) {
            // Check if false
            if (!primes[i]) {
                count++;   
            }
        }
        return count;
    }
}