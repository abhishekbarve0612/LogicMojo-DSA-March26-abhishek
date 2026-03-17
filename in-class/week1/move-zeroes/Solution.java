// Given an array of integers, move all the zeros to the end of the array while
// maintaining the relative order of the other elements.
// Input: Arr[]={10,23,0,53,0,21,0}
// Output: Arr[]={10,23,53,21,0,0,0}


class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = slow;

        while (fast < nums.length) {
            while(fast < nums.length && nums[fast] == 0) fast++;
            if (fast < nums.length) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }
            fast++;
            slow++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {10, 23, 0, 53, 0, 21, 0};
        solution.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // Output: [10, 23, 53, 21, 0, 0, 0]
    }
}