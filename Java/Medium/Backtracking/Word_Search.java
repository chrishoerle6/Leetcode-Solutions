// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an m x n grid of characters board and a string word, return 
	true if word exists in the grid. The word can be constructed from 
	letters of sequentially adjacent cells, where adjacent cells are 
	horizontally or vertically neighboring. The same letter cell may 
	not be used more than once.

	Examples:
	Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], 
	word = "ABCCED"
	Output: true

	Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], 
	word = "SEE"
	Output: true

	Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], 
	word = "ABCB"
	Output: false
	 
	Constraints:
	m == board.length
	n = board[i].length
	1 <= m, n <= 6
	1 <= word.length <= 15
	board and word consists of only lowercase and uppercase English letters.   
*/

class Solution {
    // Time Complexity: O(n)
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i + 1, j, count + 1, word) ||
                        dfs(board, i - 1, j, count + 1, word) ||
                        dfs(board, i, j + 1, count + 1, word) ||
                        dfs(board, i, j - 1, count + 1, word);
        
        board[i][j] = temp;
        return found;
    }
}