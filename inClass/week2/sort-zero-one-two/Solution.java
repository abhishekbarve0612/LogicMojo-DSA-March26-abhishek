// 1. Given an array containing only 0’s, 1’s, and 2’s, sort it in linear time and using constant space.

public class Solution {

     public void sortArray(int[] arr) {
        int start = 0, mid = 0, end = arr.length - 1;

        int pivot = 1;

        while (mid <= end) {
            if (arr[mid] < pivot) {
                int temp = arr[mid];
                arr[mid] = arr[start];
                arr[start] = temp;

                mid++;
                start++;
            } else if (arr[mid] > pivot) {
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;

                end--;
            } else {
                mid++;
            }
        }

        // return arr;
     }

     public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {0, 1, 2, 0, 1, 2};
        solution.sortArray(arr);

        for (int num : arr) { // Output: 0 0 1 1 2 2
            System.out.print(num + " ");
        }
     }
}