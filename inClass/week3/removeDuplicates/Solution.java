// nums = [0, 0, 1, 1, 2, 2, 3, 3, 4, 5]

class Solution {
    public int removeDuplicates(int[] nums) {

        int num = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[num++] = nums[i];
            }
        }

        return num;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5 };

        Solution sol = new Solution();

        int maxLen = sol.removeDuplicates(arr);

        for (int i = 0; i < maxLen; i++) System.out.print(arr[i] + " ");
    }
}