/*Given a sorted array of nums and an integer x, write a program to find the upper bound of x.



The upper bound of x is defined as the smallest index i such that nums[i] > x.



If no such index is found, return the size of the array.


Example 1

Input : n= 4, nums = [1,2,2,3], x = 2

Output:3

Explanation:

Index 3 is the smallest index such that arr[3] > x.

Example 2

Input : n = 5, nums = [3,5,8,15,19], x = 9

Output: 3

Explanation:

Index 3 is the smallest index such that arr[3] > x. */
package selfPractice.binarySearch.upperBound;

public class Solution {
    public int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;

        int res = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (x < nums[mid]) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3 };
        int[] nums2 = { 3, 5, 8, 15, 19 };
        int[] nums3 = { 3, 5, 8, 15, 19 };

        Solution solution = new Solution();
        System.out.println(solution.upperBound(nums, 2) == 3);
        System.out.println(solution.upperBound(nums2, 9) == 3);
        System.out.println(solution.upperBound(nums3, 20) == 5);
    }

}
