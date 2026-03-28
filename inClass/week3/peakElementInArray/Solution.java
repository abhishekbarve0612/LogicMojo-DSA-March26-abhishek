// Given an integer array, find the peak element in it. A peak element is an element
// that is greater than its neighbours. There might be multiple peak elements in an
// array, and the solution should report any peak element.
// Input : [8, 9, 10, 2, 5, 6]
// Output: The peak element is 10 (or 6)

class Solution {
    public int findPeakElement(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] <= nums[mid])) {
            return mid;
        }

        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            return findPeakElement(nums, left, mid - 1);
        }
        return findPeakElement(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 8, 9, 10, 2, 5, 6 };

        Solution sol = new Solution();

        int result = sol.findPeakElement(arr, 0, arr.length - 1);

        System.out.println(result);
    }
}