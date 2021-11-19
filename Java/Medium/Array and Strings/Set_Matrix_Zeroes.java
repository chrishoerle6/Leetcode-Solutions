// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an m x n integer matrix matrix, if an element is 0, set its 
	entire row and column to 0's, and return the matrix.
	You must do it in place.

	Examples:
	Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
	Output: [[1,0,1],[0,0,0],[1,0,1]]

	Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
	Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
	 
	Constraints:
	m == matrix.length
	n == matrix[0].length
	1 <= m, n <= 200
	-231 <= matrix[i][j] <= 231 - 1
	 
	Follow up:
	A straightforward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?	
*/

// Time Complexity: O(m * n)
// Space Complexity: O(1)
// Implementation: 
// Scan through every element of the array. If there is
// a 0, set the corresponding column in the 0th row to 0 and set the 
// corresponding row in the 0th column to 0. Think of these as two arrays:
// one representing the rows, one representing the columns. Because the element
// [0][0] will represent column 0 we need one extra element space or O(1) to 
// represent row 0. We don't want these to overlap. 
// Scan through every element in the array again starting at row 1 and column 1.
// If an element falls in a column or row where its 0th element is 0, then set 
// it to 0.
// Lastly, scan through the 0th row and 0th columm. If the 0th element in either
// of these is 0, set the rest of the elements in either the row or column to 0. 
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowZero = false;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    
                    if (i > 0) {
                        matrix[i][0] = 0;
                    }
                    else {
                        rowZero = true;
                    }
                }
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (matrix[0][0] == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (rowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}