## Author: Chris Hoerle
## Date: 08/20/2021

'''
	Given an integer numRows, return the first numRows of Pascal's 
	triangle. In Pascal's triangle, each number is the sum of the 
	two numbers directly above it.

	Examples:
	Input: numRows = 5
	Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

	Input: numRows = 1
	Output: [[1]]
 
	Constraints:
	1 <= numRows <= 30
'''

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        triangle = []
        
        if numRows == 0:
            return triangle
        
        first_row = []
        first_row.append(1)
        triangle.append(first_row)
        
        for i in range(1, numRows):
            prev_row = triangle[i - 1]
            curr_row = []
            curr_row.append(1)
            
            for j in range(1, i):
                curr_row.append(prev_row[j - 1] + prev_row[j])
            
            curr_row.append(1)
            triangle.append(curr_row)
        
        return triangle