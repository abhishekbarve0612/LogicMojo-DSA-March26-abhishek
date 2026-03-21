// Given an integer array arr[], the task is to find the length of the longest subarray with an
// equal number of odd and even elements.
// Input: arr[] = {1, 2, 1, 2}
// Output: 4
// Explanation:
// Subarrays in the given array are –
// {{1}, {1, 2}, {1, 2, 1}, {1, 2, 1, 2}, {2}, {2, 1}, {2, 1, 2}, {1}, {1, 2}, {2}}
// where the length of the longest subarray with an equal number of even and odd elements is 4 – {1,
// 2, 1, 2}

import java.util.*;

class Solution {
    public int[] solve(int[] arr) {
        int maxLen = 0;
        int startingIndex = -1;
        int endingIndex = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int runningSum = 0;

        for (int i = 0; i < arr.length; i++) {
            runningSum += (arr[i] % 2 == 0 ? 1 : -1);
            if (runningSum == 0) {
                startingIndex = 0;
                endingIndex = i;
                maxLen = endingIndex - startingIndex + 1;
            }

            if (map.containsKey(runningSum)) {
                if (i - map.get(runningSum) > maxLen) {
                    startingIndex = map.get(runningSum) + 1;
                    endingIndex = i;
                    maxLen = endingIndex - startingIndex + 1;
                }
            } else {
                map.put(runningSum, i);
            }
        }

        return new int[] { startingIndex, endingIndex, maxLen };
    }

    public static void test(Solution solution, int[] arr, int[] expected, String testName) {
        int[] subarray = solution.solve(arr);
        System.out.println(testName + ": arr = " + Arrays.toString(arr));
        System.out.println("Expected Indices: " + expected[0] + " " + expected[1]);
        System.out.println("Output Indices  : " + subarray[0] + " " + subarray[1]);

        boolean passed = (subarray[0] == expected[0] && subarray[1] == expected[1]);
        System.out.println("Status          : " + (passed ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        test(solution, new int[] { 1, 2, 1, 2 }, new int[] { 0, 3, 4 }, "Test 1 (basic)");
        test(solution, new int[] { 7 }, new int[] { -1, -1, 0 }, "Test 2 (single element)");
        test(solution, new int[] { 1, 3, 5, 7 }, new int[] { -1, -1, 0 }, "Test 3 (all odd)");
        test(solution, new int[] { 2, 4, 6, 8 }, new int[] { -1, -1, 0 }, "Test 4 (all even)");
        test(solution, new int[] { 1, 1, 1, 2, 4 }, new int[] { 1, 4, 4 }, "Test 5 (window not at index 0)");
    }
}