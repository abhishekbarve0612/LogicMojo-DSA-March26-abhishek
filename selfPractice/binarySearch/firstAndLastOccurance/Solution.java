/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If the target is not found in the array, return [-1, -1].


Example 1

Input: nums = [5, 7, 7, 8, 8, 10], target = 8

Output: [3, 4]

Explanation:The target is 8, and it appears in the array at indices 3 and 4, so the output is [3,4]

Example 2

Input: nums = [5, 7, 7, 8, 8, 10], target = 6

Output: [-1, -1]

Expalantion: The target is 6, which is not present in the array. Therefore, the output is [-1, -1]. */
package selfPractice.binarySearch.firstAndLastOccurance;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        int start = -1, end = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target <= nums[mid]) {
                if (target == nums[mid])
                    start = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target >= nums[mid]) {
                if (target == nums[mid])
                    end = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] { start, end };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int[] nums2 = { 5, 7, 7, 8, 8, 10 };
        int[] ans = solution.searchRange(nums, 8);
        System.out.println(ans[0] + " " + ans[1]);
        int[] ans2 = solution.searchRange(nums2, 6);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}
