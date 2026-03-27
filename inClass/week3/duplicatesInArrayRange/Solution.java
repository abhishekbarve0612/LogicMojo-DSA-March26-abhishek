// Given an integer array nums of length n where all the integers of nums are in the range [1, n]
// and each integer appears once or twice, return an array of all the integers that appears
// twice. You must write an algorithm that runs in O(n) time and uses only constant
// extra space.
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getDuplicates(int[] nums) {
        ArrayList<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int absolute = Math.abs(nums[i]) - 1;
            if (nums[absolute] > -1) {
                nums[absolute] *= -1;
            } else {
                duplicates.add(nums[absolute] * -1);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };

        ArrayList<Integer> result = solution.getDuplicates(arr);

        for (int num : result)
            System.out.print(num + " ");

    }
}