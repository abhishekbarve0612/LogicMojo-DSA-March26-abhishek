// 1099. Two Sum Less Than K
// Easy
// Topics
// conpanies icon
// Companies
// Hint
// Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

 

// Example 1:

// Input: nums = [34,23,1,24,75,33,54,8], k = 60
// Output: 58
// Explanation: We can use 34 and 24 to sum 58 which is less than 60.
// Example 2:

// Input: nums = [10,20,30], k = 15
// Output: -1
// Explanation: In this case it is not possible to get a pair sum less that 15.
 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 1000
// 1 <= k <= 2000
 
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 148,394/238.8K
// Acceptance Rate
// 62.1%
// Topics
// Mid Level
// Array
// Two Pointers
// Binary Search
// Sorting
// Biweekly Contest 3
// icon
// Companies
// 6 months ago
// Amazon
// 3


import java.util.Arrays;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int result = -1;

        Arrays.sort(nums);


        int start = 0, end = nums.length - 1;

        while (start < end) {
            int csum = nums[start] + nums[end];
            if (csum > k) {
                end--;
            } else if (csum < k) {
                result = Math.max(result, csum);
                start++;
            } else {
                end--;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {34, 23, 1, 24, 75, 33, 54, 8};
        int k1 = 60;
        int result1 = solution.twoSumLessThanK(nums1, k1);
        System.out.println(result1); // Output: 58

        int[] nums2 = {10, 20, 30};
        int k2 = 15;
        int result2 = solution.twoSumLessThanK(nums2, k2);
        System.out.println(result2); // Output: -1

        int[] nums3 = {254, 914, 110, 900, 147, 441, 209, 122, 571, 942, 136, 350, 160, 127, 178, 839, 201, 386, 462, 45, 735, 467, 153, 415, 875, 282, 204, 534, 639, 994, 284, 320, 865, 468, 1, 838, 275, 370, 295, 574, 309, 268, 415, 385, 786, 62, 359, 78, 854, 944};
        int k3 =200;
        int result3 = solution.twoSumLessThanK(nums3,k3);
        System.out.println(result3); // Output:198

        int[] nums4 = {1, 2, 4, 5};
        int k4 = 6;
        int result4 = solution.twoSumLessThanK(nums4, k4);
        System.out.println(result4); // Output: 5
    }
}