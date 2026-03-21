// arr = [1, 8, 6, 2, 5, 4, 8, 3, 7]
// result = 49

class Solution {
    public int getMaxArea(int [] height) {
        int maxWater = 0;

        int left = 0, right = height.length - 1;

        while (left < right) {
            int currentCap = (right - left) * Math.min(height[right], height[left]);
            maxWater = Math.max(maxWater, currentCap);

            if (height[left] < height[right]) left++;
            else if (height[left] > height[right])  right--;
            else {
                left++;
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        Solution solution = new Solution();

        int res = solution.getMaxArea(arr);

        System.out.println(res);
    }
}