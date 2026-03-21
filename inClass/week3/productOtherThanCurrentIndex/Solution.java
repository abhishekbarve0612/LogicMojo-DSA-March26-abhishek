// [1, 2, 3, 4]   -> [24, 12, 8, 6]
// [2 * 3 * 4, 1 * 3 * 4, 1 * 2 * 4, 1 * 2 * 3]

class Solution {
    public int[] getExemptedProduct(int[] nums) {
        int[] res = new int[nums.length];

        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i > -1; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        Solution solution = new Solution();

        int[] res = solution.getExemptedProduct(nums);

        for (int r: res) System.out.print(r + " ");
    }
}