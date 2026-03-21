// Given an unsorted array of integers, find a subarray that adds to a given number. If there
// is more than one subarray with the sum of the given number, print any of them.
// Examples:
// Input: arr[] = {1, 4, 20, 3, 10, 5}, targetsum = 33
// Output: Sum found between indexes 2 and 4
// Explanation: Sum of elements between indices
// 2 and 4 is 20 + 3 + 10 = 33

import java.util.*;

class Solution {

    public int[] getSubarrayWithSum(int[] arr, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1); // to handle the case when subarray starts from index 0

        int runningSum = 0;

        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            map.put(runningSum, i);

            if (map.containsKey(runningSum - targetSum)) {
                return new int[] { map.get(runningSum - targetSum) + 1, i};
            }
        }

        return new int[]{ -1, -1 };
    }


    public static void test(Solution solution, int[] arr, int targetSum, int[] expected, String testName) {
        int[] subarray = solution.getSubarrayWithSum(arr, targetSum);
        System.out.println(testName + ": arr = " + Arrays.toString(arr) + ", target = " + targetSum);
        System.out.println("Expected Indices: " + expected[0] + " " + expected[1]);
        System.out.println("Output Indices  : " + subarray[0] + " " + subarray[1]);
        
        boolean passed = (subarray[0] == expected[0] && subarray[1] == expected[1]);
        System.out.println("Status          : " + (passed ? "PASS" : "FAIL"));
        
        if (subarray[0] != -1 && subarray[0] <= subarray[1] && subarray[1] < arr.length) {
            int sum = 0;
            for(int i = subarray[0]; i <= subarray[1]; i++) sum += arr[i];
            System.out.println("Actual Sum of elements at these indices: " + sum + "\n");
        } else {
            System.out.println("Invalid or no subarray found\n");
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // The example case
        test(solution, new int[]{1, 4, 20, 3, 10, 5}, 33, new int[]{2, 4}, "Test 1");
        
        // Edge Case 1: Start index gets calculated as greater than end index (Self-Match)
        test(solution, new int[]{10, 20, 30}, 20, new int[]{1, 1}, "Test 2");
        
        // Edge Case 2: Legit Subarray is Completely Missed
        test(solution, new int[]{5, 10, 15}, 25, new int[]{1, 2}, "Test 3");
        
        // Edge Case 3: Claims False Subarray
        test(solution, new int[]{6, 1, 2, 3}, 12, new int[]{0, 3}, "Test 4");
     }
}