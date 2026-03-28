// Given a sorted array of non-negative distinct integers, find the smallest missing non-negative
// element in it.
// Input: nums[] = [0, 1, 2, 6, 9, 11, 15]
// Output: The smallest missing element is 3

class Solution {
    public int findSmallestMissing(int[] nums, int left, int right) {
        if (left > right) return left;

        int mid = left + (right - left) / 2;

        if (nums[mid] == mid) {
            return findSmallestMissing(nums, mid + 1, right);
        }
        return findSmallestMissing(nums, left, mid - 1);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{ 0, 1, 2, 6, 9, 11, 15 };

        Solution sol = new Solution();

        int result = sol.findSmallestMissing(arr, 0, arr.length - 1);

        System.out.println(result);
    }
}