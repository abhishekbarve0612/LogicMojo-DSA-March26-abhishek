// Given a sorted binary array, efficiently count the total number of 1’s in it.
// Input: nums[] = [0, 0, 0, 0, 1, 1, 1]
// Output: The total number of 1’s present is 3

class Solution {
    public int getOnesCount(int[] nums, int left, int right) {

        if (nums == null || nums.length == 0) return 0;

        if (nums[left] == 1) return right - left + 1;

        if (nums[right] == 0) return 0;

        if (left > right) return 0;

        int mid = left + (right - left) / 2;

        int leftCount = getOnesCount(nums, left, mid);
        int rightCount = getOnesCount(nums, mid + 1, right);

        return leftCount + rightCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 0, 0, 0, 0, 1, 1, 1 };

        Solution sol = new Solution();

        int result = sol.getOnesCount(arr, 0, arr.length - 1);

        System.out.println(result);
    }
}