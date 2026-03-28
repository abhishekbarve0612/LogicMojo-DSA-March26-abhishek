// Given the array nums after the possible rotation and an integer target, return the index of
// target if it is in nums, or -1 if it is not in nums.
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target < nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }


        return result;
    }

    public static void main (String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };

        int target = 0;

        int result = solution.search(arr, target);

        System.out.println(result);
    }
}