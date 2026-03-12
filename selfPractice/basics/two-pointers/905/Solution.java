// 905. Sort Array By Parity
// Solved
// Easy
// Topics
// conpanies icon
// Companies
// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

// Return any array that satisfies this condition.

 

// Example 1:

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 5000
// 0 <= nums[i] <= 5000

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int n = nums.length - 1;
        int end = n;


        while (start < end) {
            while (start <= n && (nums[start] % 2 == 0)) start++;
            while (end > -1 && nums[end] % 2 != 0) end--;
            if (start >= end) return nums;
            if (start <= n && nums[start] % 2 == 0 || nums[start] == 0) {
                start++;
            } else if (end > -1 && start <= n) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 1, 2, 4};
        int[] result1 = solution.sortArrayByParity(nums1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [2, 4, 3, 1]

        int[] nums2 = {0};
        int[] result2 = solution.sortArrayByParity(nums2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [0]
    }
}