// 167. Two Sum II - Input Array Is Sorted
// Solved
// Medium
// Topics
// conpanies icon
// Companies
// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

// Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.

// The tests are generated such that there is exactly one solution. You may not use the same element twice.

// Your solution must use only constant extra space.

 

// Example 1:

// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
// Example 2:

// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
// Example 3:

// Input: numbers = [-1,0], target = -1
// Output: [1,2]
// Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

// Constraints:

// 2 <= numbers.length <= 3 * 104
// -1000 <= numbers[i] <= 1000
// numbers is sorted in non-decreasing order.
// -1000 <= target <= 1000
// The tests are generated such that there is exactly one solution.
 
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 3,276,531/5.1M
// Acceptance Rate
// 64.7%
// Topics
// icon
// Companies
// 0 - 3 months
// Google
// 14
// Microsoft
// 6
// Amazon
// 4
// Meta
// 2
// Bloomberg
// 2
// 0 - 6 months
// Apple
// 2
// 6 months ago
// Yandex
// 4
// Infosys
// 2
// Adobe
// 2
// EPAM Systems
// 2
// TikTok
// 2
// Zoho
// 2
// Visa
// 2
// Zomato

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // for(int i = 0; i < numbers.length; i++) {
        //     for (int j = i + 1; j < numbers.length; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //             return new int[]{i + 1, j + 1};
        //         }
        //     }
        // }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // Output: [1, 2]

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 3]

        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]"); // Output: [1, 2]
    }
}