// 1679. Max Number of K-Sum Pairs
// Solved
// Medium
// Topics
// conpanies icon
// Companies
// Hint
// You are given an integer array nums and an integer k.

// In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

// Return the maximum number of operations you can perform on the array.

 

// Example 1:

// Input: nums = [1,2,3,4], k = 5
// Output: 2
// Explanation: Starting with nums = [1,2,3,4]:
// - Remove numbers 1 and 4, then nums = [2,3]
// - Remove numbers 2 and 3, then nums = []
// There are no more pairs that sum up to 5, hence a total of 2 operations.
// Example 2:

// Input: nums = [3,1,3,4,3], k = 6
// Output: 1
// Explanation: Starting with nums = [3,1,3,4,3]:
// - Remove the first two 3's, then nums = [1,4,3]
// There are no more pairs that sum up to 6, hence a total of 1 operation.
 

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 109
// 1 <= k <= 109
 
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 588,124/1M
// Acceptance Rate
// 56.9%
// Topics
// icon
// Companies
// 0 - 6 months
// Google
// 2
// Amazon
// 2
// 6 months ago
// Meta
// 10
// Bloomberg
// 5
// DE Shaw
// 3
// Microsoft
// 2
// Yandex

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;

        while (start < end) {
            int csum = nums[start] + nums[end];

            if (csum == k) {
                operations++;
                start++;
                end--;
            } else if (csum > k) {
                end--;
            } else {
                start++;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxOperations(new int[]{1, 2, 3, 4}, 5)); // Output: 2
        System.out.println(solution.maxOperations(new int[]{3, 1, 3, 4, 3}, 6)); // Output: 1
    }
}