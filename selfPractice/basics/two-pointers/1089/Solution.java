// 1089. Duplicate Zeros
// Solved
// Easy
// Topics
// conpanies icon
// Companies
// Hint
// Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

// Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

 

// Example 1:

// Input: arr = [1,0,2,3,0,4,5,0]
// Output: [1,0,0,2,3,0,0,4]
// Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
// Example 2:

// Input: arr = [1,2,3]
// Output: [1,2,3]
// Explanation: After calling your function, the input array is modified to: [1,2,3]
 

// Constraints:

// 1 <= arr.length <= 104
// 0 <= arr[i] <= 9

class Solution {
    public void duplicateZeros(int[] arr) {
        int end = arr.length - 1;
        int zeroes = 0;

        for (int i = 0; i <= end - zeroes; i++) {
            if (arr[i] == 0) {
                if (i == end - zeroes) {
                    arr[end] = 0;
                    end -= 1;
                    break;
                }
                zeroes++;
            }
        }

        for (int i = end - zeroes; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zeroes] = 0;
                zeroes--;
                arr[i + zeroes] = 0;
            } else {
                arr[i + zeroes] = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr1);
        System.out.println(java.util.Arrays.toString(arr1)); // Output: [1, 0, 0, 2, 3, 0, 0, 4]

        int[] arr2 = {1, 2, 3};
        solution.duplicateZeros(arr2);
        System.out.println(java.util.Arrays.toString(arr2)); // Output: [1, 2, 3]
    }

}