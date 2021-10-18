## Author: Chris Hoerle
## Date: 08/09/2021

'''
	Determine if a 9 x 9 Sudoku board is valid. Only the filled cells 
	need to be validated according to the following rules:
	Each row must contain the digits 1-9 without repetition.
	Each column must contain the digits 1-9 without repetition.
	Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
	without repetition.
	
	Note: A Sudoku board (partially filled) could be valid but is not necessarily 
	solvable. Only the filled cells need to be validated according to the mentioned 
	rules.
 
	Examples:
	Input: board = 
	[["5","3",".",".","7",".",".",".","."]
	,["6",".",".","1","9","5",".",".","."]
	,[".","9","8",".",".",".",".","6","."]
	,["8",".",".",".","6",".",".",".","3"]
	,["4",".",".","8",".","3",".",".","1"]
	,["7",".",".",".","2",".",".",".","6"]
	,[".","6",".",".",".",".","2","8","."]
	,[".",".",".","4","1","9",".",".","5"]
	,[".",".",".",".","8",".",".","7","9"]]
	Output: true

	Input: board = 
	[["8","3",".",".","7",".",".",".","."]
	,["6",".",".","1","9","5",".",".","."]
	,[".","9","8",".",".",".",".","6","."]
	,["8",".",".",".","6",".",".",".","3"]
	,["4",".",".","8",".","3",".",".","1"]
	,["7",".",".",".","2",".",".",".","6"]
	,[".","6",".",".",".",".","2","8","."]
	,[".",".",".","4","1","9",".",".","5"]
	,[".",".",".",".","8",".",".","7","9"]]
	Output: false
	Explanation: Same as the firt, except with the 5 in the top left corner being 
	modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 
	Constraints:
	board.length == 9
	board[i].length == 9
	board[i][j] is a digit or '.'.	
'''

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Python version of hashset
        row_set = collections.defaultdict(set)
        col_set = collections.defaultdict(set)
        square_set = collections.defaultdict(set) # key = (i / 3, j / 3)
        
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    if (board[i][j] in row_set[i] or
                        board[i][j] in col_set[j] or
                        board[i][j] in square_set[(i // 3, j // 3)]): # // = floor division 
                        return False
                    row_set[i].add(board[i][j])
                    col_set[j].add(board[i][j])
                    square_set[(i // 3, j //3)].add(board[i][j])
        return True