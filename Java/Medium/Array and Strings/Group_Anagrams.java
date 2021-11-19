// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an array of strings strs, group the anagrams together. 
	You can return the answer in any order. An Anagram is a word 
	or phrase formed by rearranging the letters of a different word 
	or phrase, typically using all the original letters exactly once.

	Examples:
	Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

	Input: strs = [""]
	Output: [[""]]

	Input: strs = ["a"]
	Output: [["a"]]
	 
	Constraints:
	1 <= strs.length <= 104
	0 <= strs[i].length <= 100
	strs[i] consists of lowercase English letters.	
*/

// Time Complexity: O(m * n)
// m = number of strs given in the array
// n = average length of each string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] characters = strs[i].toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            
            map.get(sorted).add(strs[i]);
        }
        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
    }
}