// 922. Sort Array By Parity II
// Solved
// Easy
// Topics
// conpanies icon
// Companies
// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

// Return any answer array that satisfies this condition.

 

// Example 1:

// Input: nums = [4,2,5,7]
// Output: [4,5,2,7]
// Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
// Example 2:

// Input: nums = [2,3]
// Output: [2,3]
 

// Constraints:

// 2 <= nums.length <= 2 * 104
// nums.length is even.
// Half of the integers in nums are even.
// 0 <= nums[i] <= 1000
 

// Follow Up: Could you solve it in-place?

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 0;

        while (even < nums.length && !(even % 2 != 0 && nums[even] % 2 == 0)) even++;
        while (odd < nums.length && !(odd % 2 == 0 && nums[odd] % 2 != 0)) odd++;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) { // even index
                if (nums[i] % 2 != 0 && even < nums.length) { // odd value
                    int temp = nums[i];
                    nums[i] = nums[even];
                    nums[even] = temp;
                    while (even < nums.length && !(even % 2 != 0 && nums[even] % 2 == 0)) even++;
                }
            } else { // odd index
                if (nums[i] % 2 == 0 && odd < nums.length) { // even value
                    int temp = nums[i];
                    nums[i] = nums[odd];
                    nums[odd] = temp;
                    while (odd < nums.length && !(odd % 2 == 0 && nums[odd] % 2 != 0)) odd++;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {4, 2, 5, 7};
        int[] result1 = solution.sortArrayByParityII(nums1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [4, 5, 2, 7]

        int[] nums2 = {2, 3};
        int[] result2 = solution.sortArrayByParityII(nums2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [2, 3]
    }
}