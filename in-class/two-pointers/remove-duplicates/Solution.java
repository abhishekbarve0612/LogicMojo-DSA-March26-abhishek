// Given a sorted array, remove all duplicates and return the length of the modified array
// solution.
// Examples: nums = {1, 1, 2, 2, 2, 3, 4, 4}; Output: 4


class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = slow + 1;

        while (fast < nums.length) {
            while (fast < nums.length && nums[slow] == nums[fast]) fast++;
            if (fast < nums.length) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 2, 2, 2, 3, 4, 4};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println(k1); // Output: 4, nums = [1, 2, 3, 4]
        System.out.println(java.util.Arrays.toString(nums1)); // Output: [1, 2, 3, 4]
    }
}