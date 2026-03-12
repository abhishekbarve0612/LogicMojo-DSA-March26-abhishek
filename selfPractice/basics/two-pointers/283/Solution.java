// 283. Move Zeroes
// Solved
// Easy
// Topics
// conpanies icon
// Companies
// Hint
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
 

// Follow up: Could you minimize the total number of operations done?

class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = slow;

        while (fast < nums.length) {
            while(fast < nums.length && nums[fast] == 0) fast++;
            if (fast < nums.length) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }
            fast++;
            slow++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // Output: [1, 3, 12, 0, 0]

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        solution.moveZeroes(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // Output: [1, 2, 2, 3, 4, 0, 0, 0]
    }
}