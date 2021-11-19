// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given an integer array nums and an integer k, return the k most 
	frequent elements. You may return the answer in any order.

 	Examples:
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]

	Input: nums = [1], k = 1
	Output: [1]
	 
	Constraints:
	1 <= nums.length <= 105
	k is in the range [1, the number of unique elements in the array].
	It is guaranteed that the answer is unique.
	 

	Follow up: Your algorithm's time complexity must be better than O(n log n), 
	where n is the array's size.			
*/

class Solution {
    // Time Complexity: O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        // Create a map storing the frequencies of the numbers
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // Create a priority queue storing the map entries in descending
        // order of values. Because priority queues default to ascending
        // order, we need some logic to make it ascending.
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new 
            PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        
        for (Map.Entry entry : map.entrySet()) {
            pq.add(entry);
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        
        return result;
    }
}