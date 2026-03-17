// Given an array containing only 0s and 1s, find the largest subarray which contains equal
// no of 0s and 1s.
// Input: arr[] = {0, 0, 1, 1, 0}
// Output: 0 to 3 Or 1 to 4

import java.util.*;

class Solution {

    public int[] getSubarrayWithEqualZeroesAndOnes(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int runningSum = 0;
        int maxLen = 0;
        int startingIndex = -1;
        int endingIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            runningSum += (arr[i] == 0 ? -1 : 1);

            if (runningSum == 0) {
                startingIndex = 0;
                maxLen = i + 1;
                endingIndex = i;
            }

            // Since the runningSum is present in the map,
            // it means that same sum was obtained at some previous index as well.
            // so the elements between those two indices add up to zero
            // prefixSum[j] - prefixSum[i] = 0 => prefixSum[j] = prefixSum[i]
            if (map.containsKey(runningSum)) {
                if (i - map.get(runningSum) > maxLen) {
                    startingIndex = map.get(runningSum);
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
        int[] subarray = solution.getSubarrayWithEqualZeroesAndOnes(arr);
        System.out.println(testName + ": arr = " + Arrays.toString(arr));
        System.out.println("Expected Indices: " + expected[0] + " " + expected[1]);
        System.out.println("Output Indices  : " + subarray[0] + " " + subarray[1]);
        
        boolean passed = (subarray[0] == expected[0] && subarray[1] == expected[1]);
        System.out.println("Status          : " + (passed ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        test(solution, new int[]{0, 0, 1, 1, 0}, new int[]{0, 3, 4}, "Test 1");
        test(solution, new int[]{0, 1, 0, 1, 0}, new int[]{0, 3, 4}, "Test 2");
        test(solution, new int[]{1, 1, 1, 1}, new int[]{-1, -1, 0}, "Test 3");
        test(solution, new int[]{0, 0, 0}, new int[]{-1, -1, 0}, "Test 4");
        test(solution, new int[]{0, 1, 1, 0}, new int[]{0, 3, 4}, "Test 5");
     }  
}