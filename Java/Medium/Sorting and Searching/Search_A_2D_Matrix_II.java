// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Write an efficient algorithm that searches for a target value in an 
	m x n integer matrix. The matrix has the following properties:
	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	 
	Examples:
	Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],
	[18,21,23,26,30]], target = 5
	Output: true

	Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],
	[18,21,23,26,30]], target = 20
	Output: false
	 
	Constraints:
	m == matrix.length
	n == matrix[i].length
	1 <= n, m <= 300
	-109 <= matrix[i][j] <= 109
	All the integers in each row are sorted in ascending order.
	All the integers in each column are sorted in ascending order.
	-109 <= target <= 109			
*/

class Solution {
    // Brute Force Solution: Traverse through entire matrix searching
    // each element for the target but O(n^2) time complexity.
    // O(i + j) Solution: Because rows and columns are sorted in ascending
    // order we start in the bottom left corner of the matrix. If the target 
    // is greater than this value, we know it cant't be in this column, so
    // we move one column to the right. If the target is less than this value,
    // we know it can't be in this row, so we move one row up. We repeat this
    // until we find the target or traverse through the entire matrix.
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] < target) {
                j++;
            }
            else if (matrix[i][j] > target) {
                i--;
            }
        }
        
        return false;
    }
}