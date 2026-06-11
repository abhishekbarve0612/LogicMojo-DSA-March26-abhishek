/*Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.


Example 1

Input: nums = [1, 3, 5, 6], target = 5

Output: 2

Explanation: The target value 5 is found at index 2 in the sorted array. Hence, the function returns 2.

Example 2

Input: nums = [1, 3, 5, 6], target = 2

Output: 1

Explanation: The target value 2 is not found in the array. However, it should be inserted at index 1 to maintain the sorted order of the array. */
package selfPractice.binarySearch.searchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        int res = high + 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target <= nums[mid]) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int[] nums2 = { 1, 3, 5, 6 };

        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 5) == 2);
        System.out.println(solution.searchInsert(nums2, 2) == 1);
    }
}
