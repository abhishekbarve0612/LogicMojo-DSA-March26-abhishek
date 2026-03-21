// 1.       Given an integer array arr[], the task is to find the length of the longest subarray with an equal number of odd and even elements.

// Input: arr[] = {1, 2, 1, 2}




// Output: 4


import java.util.HashMap;

class Solution {
    public int maxSubArrayOfEqualEvenAndOdds(int[] nums) {
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 1;
            } else {
                nums[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int targetSum = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (map.containsKey(currentSum - targetSum)) {
                int startIndex = map.get(currentSum - targetSum);
                int length = i - startIndex;
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                map.put(currentSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int result = solution.maxSubArrayOfEqualEvenAndOdds(nums);
        System.out.println("Length of longest subarray with equal even and odd elements: " + result); // Output: Length of longest subarray with equal even and odd elements: 6

        int[] nums2 = {1, 2, 1, 2};
        int result2 = solution.maxSubArrayOfEqualEvenAndOdds(nums2);
        System.out.println("Length of longest subarray with equal even and odd elements: " + result2); // Output: Length of longest subarray with equal even and odd elements: 4
    }
}