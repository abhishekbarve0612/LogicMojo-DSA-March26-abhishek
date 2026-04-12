/**
 * Problem Description
Given an unsorted numsay of integers, find the smallest missing positive integer. The space complexity need not be O(1), you can also implement a O(N) space complexity solution.

Input format
There are 2 lines of input.

First line contains 1 integer N - Number of elements in the numsay.

Second line contains space separated N integers.

Output format
Print the smallest missing positive integer.

Sample Input 1
4

3 4 -1 1

Sample Output 1
2

Explanation 1
2 is the smallest positive integer which is missing as 1 is already present in the numsay. Note that 0 will not be considered as positive.

Constraints
N <= 200000

-2 ^ 31 <= Range of values <= 2 ^ 31 - 1
 */

package selfPractice.basics.adHoc.missingSmallestPositiveInArray;

import java.util.Arrays;

public class Solution {

    public static int firstMissingSmallestPositive(int[] nums) {
        Arrays.sort(nums);

        int counter = 1;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] < 1 || (i > 0 && nums[i] == nums[i - 1]))
                i++;
            else if (nums[i] == counter) {
                i++;
                counter++;
            } else {
                return counter;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingSmallestPositive(new int[] { 3, 4, -1, 1 }));
        System.out.println(
                firstMissingSmallestPositive(new int[] { -10000, -1203, -123, -456, -100, -1, -654, -242, -10, -17 }));
    }
}

/**
 * Approach 1:
 * - Sort the numsay
 * - while ignoring numbers < 1, iterating through the numsay from counter = 1
 * - Skipping the duplicates, if the current element is equal to the previous
 * element, skip it
 * - if different, increment count, match count with current element, if
 * different, current count is missing number
 * 
 * Time complexity: O(n log n)
 * Space complexity: O(1)
 * 
 * 
 * Approach 2:
 * - Use a hash set to store the numbers
 * - Iterate through the numsay and add the numbers to the hash set
 * - Iterate from 1 to n and check if the number is present in the hash set
 * - If the number is not present in the hash set, return the number
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * 
 * Approach 3:
 * - Keep a boolean array of size n + 1
 * - Iterate through nums, if num is in range of 1 to n, mark the index num - 1
 * - Iterate through the boolean array, if the index is not marked, return the
 * index + 1
 * - If all the indices are marked, return n + 1
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * 
 */