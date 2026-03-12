// 977. Squares of a Sorted Array
// Solved
// Easy
// Topics
// conpanies icon
// Companies
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in non-decreasing order.
 

// Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

class Solution {
    public int[] sortedSquares(int[] nums) {
        int first = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        int counter = end;

        while (first <= end) {
            if (Math.abs(nums[first]) > Math.abs(nums[end])) {
                result[counter] = nums[first] * nums[first];
                first++;
            } else {
                result[counter] = nums[end] * nums[end];
            end--;
            }

            counter--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = solution.sortedSquares(nums1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [0, 1, 9, 16, 100]

        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = solution.sortedSquares(nums2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [4, 9, 9, 49, 121]
    }
}

// -1 -3 -2 25
// 1 -3 4 25
// -1 9 4 25
// 1 9 4 25

// -4 -1 0 3 10
//         16  100