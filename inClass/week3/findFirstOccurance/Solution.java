// Given a sorted integer array, find the index of a given number’s first occurence. If the
// element is not present in the array, report that as wel

// package inClass.week3.findFirstOccurance;

class Solution {

    public int findFirstOccurance(int[] nums, int target) {

        int first = 0, last = nums.length - 1;
        int result = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (nums[mid] == target) {
                result = mid;
                last = mid - 1;
            } else if (nums[mid] < target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9 };
        int target = 10;

        Solution sol = new Solution();
        int result = sol.findFirstOccurance(nums, target);
        System.out.println(result);

    }
}
