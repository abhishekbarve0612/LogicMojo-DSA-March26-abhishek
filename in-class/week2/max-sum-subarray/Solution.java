// Given an array arr[] of size N. The task is to find the sum of the contiguous subarray within a
// arr[] with the largest sum.
// A[]= { -2, -3, 4, -1, -2, 1, 5, -3 };
// Maximum contiguous sum is 7
// Starting index 2
// Ending index 6

import java.util.*;

class Solution {
    public int solve(int[] arr) {
        int maxTillNow = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxTillNow += arr[i];

            maxSoFar = Math.max(
                maxTillNow,
                maxSoFar
            );

            if (maxTillNow < 0) maxTillNow = 0;
        }

        return maxSoFar;

    }

    public static void test(Solution solution, int[] arr, int expected, String testName) {
        int result = solution.solve(arr);
        System.out.println(testName + ": arr = " + Arrays.toString(arr));
        System.out.println("Expected: " + expected);
        System.out.println("Output: " + result);
        boolean passed = (result == expected);
        System.out.println("Status: " + (passed ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        test(solution, new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }, 7, "Test 1");
        test(solution, new int[] { 1, 2, 3, 4, 5 }, 15, "Test 2");
        test(solution, new int[] { -1, -2, -3, -4, -5 }, -1, "Test 3");
        test(solution, new int[] { 0, 0, 0 }, 0, "Test 4");
        test(solution, new int[] { 1, -2, 3, -4, 5 }, 5, "Test 5");
    }
}
