// Find the majority element in the array. A majority element in an array A[] of size n is an
// element that appears more than n/2 times (and hence there is at most one such
// element).
// Input : A[]={3, 3, 4, 2, 4, 4, 2, 4, 4}
// Output : 4
// Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size.

import java.util.*;

class Solution {
    public int solve(int[] arr) {

        int majorityElement = arr[0];

        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != majorityElement) count--;
            else count++;
            if (count == 0) {
                majorityElement = arr[i];
                count = 1;
            }
        }

        int temp = 0;

        for (int num: arr) {
            if (majorityElement == num) temp++;
        }

        return temp > arr.length / 2 ? majorityElement : -1;

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

        test(solution, new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 }, 4, "Test 1");
        test(solution, new int[] { 1, 2, 3, 4, 5 }, -1, "Test 2");
        test(solution, new int[] { 1, 1, 1, 1, 1 }, 1, "Test 3");
        test(solution, new int[] { 2, 2, 1, 1, 1, 2, 2 }, 2, "Test 4");
        test(solution, new int[] { 1, 2, 3, 1, 1, 1, 1 }, 1, "Test 5");
    }
}