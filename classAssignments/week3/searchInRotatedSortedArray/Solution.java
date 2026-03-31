// Given an array of distinct elements, which is formed from some places rotation of a sorted array, find if a given element is present in the array or not.
// Note: Try to do it in O(logn) runtime complexity

// Input Format

// First line is the length of the array
// Second line is the target element
// Next line is the elements of the array

// Constraints

// 1 <= arr.length <= 5000
// -104 <= arr[i] <= 104
// All values of arr are unique.
// arr is an ascending array that is possibly rotated.
// -104 <= target <= 104

// Output Format

// Return the index of target if it is in array, or -1 if it is not in array.

// Sample Input 0

// 7
// 0
// 4 5 6 7 0 1 2
// Sample Output 0

// 4

package classAssignments.week3.searchInRotatedSortedArray;

import java.util.List;

public class Solution {
    public static int search_element(List<Integer> arr, int target) {
        int start = 0, end = arr.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == target) return mid;

            if (arr.get(start) <= arr.get(mid)) {
                if (target < arr.get(mid) && target >= arr.get(start)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr.get(mid) && target <= arr.get(end)) start = mid + 1;
                else end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new java.util.ArrayList<>(java.util.Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        int target = 0;

        int result = search_element(arr, target);

        System.out.println(result);
    }
}
