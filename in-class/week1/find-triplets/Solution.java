// Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
// Examples: Input: arr[] = {0, -1, 2, -3, 1}
// Output: (0 -1 1), (2 -3 1)
// Explanation: The triplets with zero sum are 0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
// Input: arr[] = {1, -2, 1, 0, 5}
// Output: 1 -2 1
// Explanation: The triplets with zero sum is 1 + -2 + 1 = 0

import java.util.Arrays;

class Solution {
    public int[][] threeSum(int[] nums) {
        int[][] result = new int[0][];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result = Arrays.copyOf(result, result.length + 1);

                    result[result.length - 1] = new int[]{nums[i], nums[left], nums[right]};
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {0, -1, 2, -3, 1};
        int[][] result1 = solution.threeSum(nums1);
        for (int[] triplet : result1) {
            System.out.println(Arrays.toString(triplet)); // Output: [0, -1, 1], [2, -3, 1]
        }

        int[] nums2 = {1, -2, 1, 0, 5};
        int[][] result2 = solution.threeSum(nums2);
        for (int[] triplet : result2) {
            System.out.println(Arrays.toString(triplet)); // Output: [1, -2, 1]
        }
    }
}