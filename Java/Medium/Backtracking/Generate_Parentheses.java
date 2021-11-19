// Author: Chris Hoerle
// Date: 11/19/2021

/*
    Given n pairs of parentheses, write a function to generate all 
    combinations of well-formed parentheses.

    Examples:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

    Input: n = 1
    Output: ["()"]
     
    Constraints:
    1 <= n <= 8  
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        backTrack(result, "", n, 0, 0);
        
        return result;
    }
    
    public void backTrack(List<String> result, String current, int max, int open, int close) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        if (open < max) {
            backTrack(result, current + "(", max, open + 1, close);    
        }
        if (close < open) {
            backTrack(result, current + ")", max, open, close + 1);   
        }
    }
}