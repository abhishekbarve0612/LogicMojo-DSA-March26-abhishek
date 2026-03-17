// An array contains both positive and negative numbers in random order.
// Rearrange the array elements so that all negative numbers appear before all
// positive numbers.
// Examples :
// Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
// Output: -12 -13 -5 -7 -3 -6 11 6 5

import java.util.*;

class Solution {
    public int[] solve(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            while (start < end && arr[start] < 0)
                start++;
            while (start < end && arr[end] > 0)
                end--;

            if (start < end && arr[start] > 0 && arr[end] < 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else {
                start++;
            }
        }

        return arr;
    }

    public static void test(Solution solution, int[] arr, int[] expected, String testName) {
        int[] subarray = solution.solve(arr);
        System.out.println(testName + ": arr = " + Arrays.toString(arr));
        System.out.println("Expected: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(expected[i] + " ");
        }
        System.out.println();
        System.out.println("Output: ");
        for (int i = 0; i < subarray.length; i++) {
            System.out.print(subarray[i] + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        test(solution, new int[] { -12, 11, -13, -5, 6, -7, 5, -3, -6 },
                new int[] { -12, -13, -5, -7, -3, -6, 11, 6, 5 }, "Test 1");
        test(solution, new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 }, "Test 2");
        test(solution, new int[] { -1, -2, -3, -4, -5 }, new int[] { -1, -2, -3, -4, -5 }, "Test 3");
        test(solution, new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 }, "Test 4");
        test(solution, new int[] { 1, -1, 2, -2, 3, -3 }, new int[] { -1, -2, -3, 1, 2, 3 }, "Test 5");
    }
}