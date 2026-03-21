// Given an array that contains both positive and negative integers, find the
// product
// of the maximum product subarray.
// Input: arr[] = {6, -3, -10, 0, 2}
// Output: 180 // The subarray is {6, -3, -10}

import java.util.*;

class Solution {
    public int solve(int[] arr) {
        int maxTillNow = arr[0];
        int minTillNow = arr[0];

        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(
                    arr[i],
                    Math.max(
                            arr[i] * maxTillNow,
                            arr[i] * minTillNow));

            minTillNow = Math.min(
                    arr[i],
                    Math.min(
                            arr[i] * maxTillNow,
                            arr[i] * minTillNow));
            maxTillNow = temp;

            maxSoFar = Math.max(maxSoFar, maxTillNow);
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

        test(solution, new int[] { 6, -3, -10, 0, 2 }, 180, "Test 1");
        test(solution, new int[] { -1, -2, -3, 0, 4 }, 6, "Test 2");
        test(solution, new int[] { 1, 2, 3, 4, 5 }, 120, "Test 3");
        test(solution, new int[] { -1, -2, -3, -4, -5 }, 120, "Test 4");
        test(solution, new int[] { 0, 0, 0 }, 0, "Test 5");
    }
}