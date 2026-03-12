// 2563. Count the Number of Fair Pairs
// Medium
// Topics
// conpanies icon
// Companies
// Hint
// Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

// A pair (i, j) is fair if:

// 0 <= i < j < n, and
// lower <= nums[i] + nums[j] <= upper
 

// Example 1:

// Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
// Output: 6
// Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
// Example 2:

// Input: nums = [1,7,9,2,5], lower = 11, upper = 11
// Output: 1
// Explanation: There is a single fair pair: (2,3).
 

// Constraints:

// 1 <= nums.length <= 105
// nums.length == n
// -109 <= nums[i] <= 109
// -109 <= lower <= upper <= 109
 
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 237,403/450.5K
// Acceptance Rate
// 52.7%
// Topics
// icon
// Companies
// 0 - 6 months
// McDonalds
// 2
// 6 months ago
// Google
// 13
// Amazon
// 10
// Bloomberg
// 6
// Meta
// 3
// Salesforce
// 3
// Microsoft
// 2
// tcs
// 2
// Qualcomm

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;

        long lowerBoundPairs = 0;

        while (start < end ) {
            int csum = nums[start] + nums[end];
            if (csum < lower) {
                lowerBoundPairs += (end - start);
                start++;
            } else {
                end--;
            }
        }

        start = 0;
        end = nums.length - 1;

        long upperBoundPairs = 0;

        while (start < end ) {
            int csum = nums[start] + nums[end];
            if (csum < upper + 1) {
                upperBoundPairs += (end - start);
                start++;
            } else {
                end--;
            }
        }

        return upperBoundPairs - lowerBoundPairs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {0,1,7,4,4,5};
        int lower1 = 3;
        int upper1 = 6;
        long result1 = solution.countFairPairs(nums1, lower1, upper1);
        System.out.println(result1); // Output: 6

        int[] nums2 = {1,7,9,2,5};
        int lower2 = 11;
        int upper2 = 11;
        long result2 = solution.countFairPairs(nums2, lower2, upper2);
        System.out.println(result2); // Output: 1
    }
}